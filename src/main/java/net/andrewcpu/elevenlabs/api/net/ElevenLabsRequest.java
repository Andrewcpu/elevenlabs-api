package net.andrewcpu.elevenlabs.api.net;

import net.andrewcpu.elevenlabs.api.net.multipart.MultipartForm;
import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.enums.ContentType;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import net.andrewcpu.elevenlabs.util.StreamedResponseCallback;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public abstract class ElevenLabsRequest<T> {
	protected ContentType contentType = ContentType.JSON;
	protected ResponseType responseType = ResponseType.JSON;
	protected final HTTPMethod method;
	protected List<String> parameters;
	protected ResultTransformer<T> resultTransformer;
	protected JSONObject body;
	protected File outputFilePath;
	protected MultipartForm multipartForm;
	protected StreamedResponseCallback streamedResponseCallback;

	public ElevenLabsRequest(List<String> parameters, JSONObject body, HTTPMethod method, ResultTransformer<T> resultTransformer) {
		this.method = method;
		this.parameters = parameters;
		this.body = body;
		this.resultTransformer = resultTransformer;
	}

	public ElevenLabsRequest(JSONObject body, HTTPMethod method) {
		this.body = body;
		this.method = method;
	}

	public ElevenLabsRequest(List<String> parameters, HTTPMethod method) {
		this.parameters = parameters;
		this.method = method;
	}

	public ElevenLabsRequest(List<String> parameters, HTTPMethod method, ResultTransformer<T> resultTransformer) {
		this.parameters = parameters;
		this.method = method;
		this.resultTransformer = resultTransformer;
	}

	public ElevenLabsRequest(HTTPMethod method) {
		this.method = method;
	}

	public ElevenLabsRequest(HTTPMethod method, ResultTransformer<T> resultTransformer) {
		this.method = method;
		this.resultTransformer = resultTransformer;
	}

	public ElevenLabsRequest(JSONObject body, HTTPMethod method, ResultTransformer<T> resultTransformer) {
		this.resultTransformer = resultTransformer;
		this.method = method;
		this.body = body;
	}

	public abstract String getEndpoint();


	public MultipartForm getMultipartForm() {
		return multipartForm;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public HTTPMethod getMethod() {
		return method;
	}

	public File getOutputFilePath() {
		return outputFilePath;
	}

	public StreamedResponseCallback getStreamedResponseCallback() {
		return streamedResponseCallback;
	}

	public ResultTransformer<T> getResultTransformer() {
		return resultTransformer;
	}

	public String getFormattedEndpoint(){
		String endpoint = getEndpoint();
		if(endpoint.startsWith("/")){
			endpoint = endpoint.substring(1);
		}
		if(parameters != null && !parameters.isEmpty()){
			for(int i = 0; i<parameters.size(); i++){
				endpoint = endpoint.replaceFirst("\\{.*?}", parameters.get(i));
			}
		}
		return endpoint;
	}


	public JSONObject getBody() {
		return body;
	}


	public ResponseType getResponseType() {
		return responseType;
	}

}
