package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.net.ElevenLabsResponse;
import net.andrewcpu.elevenlabs.enums.ContentType;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import net.andrewcpu.elevenlabs.util.DebugLogger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static net.andrewcpu.elevenlabs.util.MultipartUtil.*;

@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public class ElevenLabsAPI {
	private static ElevenLabsAPI instance;
	private static final String baseURL = "https://api.elevenlabs.io/v1/";
	private static boolean debugMode = false;

	public static boolean isDebugMode() {
		return debugMode;
	}

	public static <T> T getRequestResult(ElevenLabsRequest<T> request) throws ElevenLabsException {
		return ElevenLabsAPI.getInstance().getResult(request);
	}

	public static void setDebugMode(boolean enabled) {
		debugMode = enabled;
	}

	public static ElevenLabsAPI getInstance() {
		if (instance == null) {
			instance = new ElevenLabsAPI();
		}
		return instance;
	}

	private boolean instantiated;
	private String apiKey;

	public ElevenLabsAPI() {
		instantiated = false;
	}

	public void setAPIKey(String apiKey) {
		instantiated = true;
		this.apiKey = apiKey;
	}

	private void checkOrThrow(ElevenLabsResponse<?> response) throws ElevenLabsException {
		if (response == null) {
			throw new ElevenLabsValidationException("An error has occurred.");
		}
		if (!response.isSuccessful()) {
			throw response.getException();
		}
	}

	public <T> T getResult(ElevenLabsRequest<T> request) throws ElevenLabsException {
		ElevenLabsResponse<T> response = sendRequest(request);
		checkOrThrow(response);
		return response.getResult();
	}

	private <T> ElevenLabsResponse<T> sendRequest(ElevenLabsRequest<T> request) throws ElevenLabsException {
		if (!instantiated) {
			throw new ElevenLabsAPINotInitiatedException();
		}

		String formattedEndpoint = request.getFormattedEndpoint();

		URL url;
		int responseCode;
		InputStream successStream = null, errorStream = null;

		try {
			String boundary = "---------------------------" + System.currentTimeMillis();
			DebugLogger.log(ElevenLabsAPI.class,"Request to " + baseURL + ", " + formattedEndpoint);
			url = new URL(baseURL + formattedEndpoint);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			setupConnection(request, boundary, connection);

			if (request.getContentType() == ContentType.JSON) {
				handleJSON(request, connection);
			} else if (request.getContentType() == ContentType.MULTIPART) {
				handleMultipart(request, connection, boundary);
				connection.getOutputStream().flush();
				connection.getOutputStream().close();
			}

			if(request.getResponseType() == ResponseType.FILE_STREAM) {
				request.getStreamedResponseCallback().handleStreamedResponse(connection.getInputStream(), connection.getErrorStream());
			}

			responseCode = connection.getResponseCode();
			if (responseCode >= 200 && responseCode < 300) {
				successStream = connection.getInputStream();
			} else {
				errorStream = connection.getErrorStream();
			}
		} catch (IOException e) {
			throw new ElevenLabsException(e);
		}

		return new ElevenLabsResponse<>(responseCode, errorStream, successStream, request);
	}

	private void setupConnection(ElevenLabsRequest<?> request, String boundary, HttpURLConnection connection) throws ProtocolException {
		connection.setConnectTimeout(60000);
		connection.setReadTimeout(60000);
		connection.setRequestMethod(request.getMethod().name());
		String contType = request.getContentType().getType();
		if (request.getContentType() == ContentType.MULTIPART) {
			contType += "; boundary=" + boundary;
		}
		connection.setRequestProperty("xi-api-key", apiKey);
		connection.setRequestProperty("Content-Type", contType); // this can be done better.
		connection.setDoOutput(true);
	}

	private static void handleJSON(ElevenLabsRequest<?> request, HttpURLConnection connection) throws IOException {
		if (request.getBody() != null) {
			connection.getOutputStream().write(request.getBody().toJSONString().getBytes(StandardCharsets.UTF_8));
		}
	}

	private static void handleMultipart(ElevenLabsRequest<?> request, HttpURLConnection connection, String boundary) throws IOException {
		writeFormValues(request, connection, boundary);
		String footer = "--" + boundary + "--\r\n";
		connection.getOutputStream().write(footer.getBytes(StandardCharsets.UTF_8));
	}
}
