package net.andrewcpu.elevenlabs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.enums.HttpRequestType;
import net.andrewcpu.elevenlabs.exceptions.ValidationException;
import net.andrewcpu.elevenlabs.model.error.ValidationError;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class ElevenNetworkUtil {
	private static final String BASE_URL = "https://api.elevenlabs.io/";
	private static final List<String> FILE_RESULT_TYPES = List.of("application/octet-stream", "audio/mpeg", "application/zip");


	private static void applyHeader(HttpRequest request) {
		request.setHeader("xi-api-key", ElevenLabs.getApiKey());
	}

	public static String buildQueryParameters(Map<String, String> parameters) {
		StringJoiner queryParameters = new StringJoiner("&");
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			String encodedKey = encodeValue(entry.getKey());
			String encodedValue = encodeValue(entry.getValue());
			queryParameters.add(encodedKey + "=" + encodedValue);
		}
		return queryParameters.toString();
	}

	private static String encodeValue(String value) {
		return URLEncoder.encode(value, StandardCharsets.UTF_8);
	}

	public static HttpUriRequestBase getRequest(HttpRequestType type, String path) {
		switch (type) {
			case PUT:
				return new HttpPut(path);
			case POST:
				return new HttpPost(path);
			case DELETE:
				return new HttpDelete(path);
			default:
				return new HttpGet(path);
		}
	}

	private static List<NameValuePair> getParameters(Object payload) {
		List<NameValuePair> parameters = new ArrayList<>();
		if (payload instanceof Map<?, ?>) {
			Map<?, ?> payloadMap = (Map<?, ?>) payload;
			for (Map.Entry<?, ?> entry : payloadMap.entrySet()) {
				parameters.add(new BasicNameValuePair(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
			}
		}
		return parameters;
	}

	private static HttpUriRequestBase handleNonBodyRequest(HttpRequestType requestType, Object payload, String path) {
		List<NameValuePair> parameters = getParameters(payload);
		HttpUriRequestBase request = getRequest(requestType, path);
		try {
			request.setUri(new URIBuilder(path).addParameters(parameters).build());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		return request;
	}

	private static HttpEntity handleMultipartBodyRequest(Object payload) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		Map<?, ?> payloadMap = (Map<?, ?>) payload;
		for (Map.Entry<?, ?> entry : payloadMap.entrySet()) {
			if (entry.getValue() instanceof File) {
				builder.addPart(entry.getKey().toString(), new FileBody((File) entry.getValue()));
			} else if (entry.getValue() instanceof String) {
				builder.addTextBody(entry.getKey().toString(), (String) entry.getValue());
			} else if (entry.getValue() instanceof String[]) {
				String[] strings = (String[]) entry.getValue();
				for (String s : strings) {
					builder.addTextBody(entry.getKey().toString(), s);
				}
			} else if (entry.getValue() instanceof File[]) {
				File[] files = (File[]) entry.getValue();
				for (File f : files) {
					builder.addPart(entry.getKey().toString(), new FileBody(f));
				}
			} else if (entry.getValue() instanceof Map<?, ?>) {
				Map<?, ?> subMap = (Map<?, ?>) entry.getValue();
				for (Map.Entry<?, ?> subEntry : subMap.entrySet()) {
					builder.addTextBody(entry.getKey().toString() + "[" + subEntry.getKey().toString() + "]", subEntry.getValue().toString());
				}
			} else {
				throw new IllegalArgumentException("Unsupported payload value type");
			}
		}
		return builder.build();
	}

	private static HttpEntity handleJSONBody(Object payload) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonPayload = objectMapper.writeValueAsString(payload);
		return new StringEntity(jsonPayload, ContentType.APPLICATION_JSON);
	}

	private static HttpUriRequestBase handleBodyRequest(HttpRequestType type, Object payload, String path) throws JsonProcessingException {
		HttpEntity requestEntity;
		if (payload instanceof Map<?, ?>) {
			requestEntity = handleMultipartBodyRequest(payload);
		} else if (payload != null) {
			requestEntity = handleJSONBody(payload);
		} else {
			requestEntity = new StringEntity("");
		}
		HttpUriRequestBase request = getRequest(type, path);
		request.setEntity(requestEntity);
		return request;
	}

	public static HttpUriRequestBase getRequest(HttpRequestType method, String path, Object payload) throws JsonProcessingException {
		HttpUriRequestBase request;
		if (method == HttpRequestType.GET || method == HttpRequestType.DELETE) {
			request = handleNonBodyRequest(method, payload, path);
		} else {
			request = handleBodyRequest(method, payload, path);
		}
		applyHeader(request);
		return request;
	}

	public static <T> T sendRequest(HttpRequestType method, String path, Object payload, Class<T> responseType) {
		ObjectMapper objectMapper = new ObjectMapper();
		path = BASE_URL + path;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpUriRequestBase request = getRequest(method, path, payload);

			return getRequestResult(responseType, objectMapper, httpclient, request);
		} catch (IOException | ValidationException e) {
			throw new RuntimeException(e);
		}
	}

	private static <T> T getRequestResult(Class<T> responseType, ObjectMapper objectMapper, CloseableHttpClient httpclient, HttpUriRequestBase request) throws ValidationException {
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(request);
			if (response.getCode() == 422) {
				String responseString = EntityUtils.toString(response.getEntity());
				ValidationError error = objectMapper.readValue(responseString, ValidationError.class);
				response.close();
				httpclient.close();
				throw new ValidationException(error);
			}

			if (response.getEntity().getContentType().contains("application/json")) {
				String responseString = EntityUtils.toString(response.getEntity());
				response.close();
				httpclient.close();
				if (responseType == String.class) {
					return (T) responseString;
				}
				return objectMapper.readValue(responseString, responseType);
			} else if (FILE_RESULT_TYPES.stream().anyMatch(response.getEntity().getContentType()::contains)) {
				if (responseType.isAssignableFrom(InputStream.class)) {
					return (T) response.getEntity().getContent();
				} else if (responseType.isAssignableFrom(File.class)) {
					File tempFile = File.createTempFile("download", "tmp");
					try (InputStream in = response.getEntity().getContent();
					     OutputStream out = new FileOutputStream(tempFile)) {
						byte[] buffer = new byte[1024];
						int len;
						while ((len = in.read(buffer)) != -1) {
							out.write(buffer, 0, len);
						}
					}
					response.close();
					httpclient.close();
					return (T) tempFile;
				} else {
					response.close();
					httpclient.close();
					throw new RuntimeException("Unsupported response type");
				}
			} else {
				response.close();
				httpclient.close();
				throw new RuntimeException("Unexpected Content-Type in response");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				httpclient.close();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			throw new RuntimeException("Failed to process JSON", e);
		}
	}

}
