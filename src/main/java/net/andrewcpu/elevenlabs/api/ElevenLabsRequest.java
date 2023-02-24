package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.api.multipart.MultipartForm;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.enums.ContentType;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public abstract class ElevenLabsRequest<T> {
	protected List<String> parameters;
	protected final HTTPMethod method;
	protected ResultTransformer<T> resultTransformer;
	protected JSONObject body;
	protected ResponseType responseType = ResponseType.JSON;
	protected File outputFilePath;
	protected ContentType contentType = ContentType.JSON;
	protected MultipartForm multipartForm;

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



	public ResultTransformer<T> getResultTransformer() {
		return resultTransformer;
	}

	public String getFormattedEndpoint(){
		String endpoint = getEndpoint();
		if(endpoint.startsWith("/")){
			endpoint = endpoint.substring(1);
		}
		if(parameters != null && parameters.size() > 0){
			return endpoint.formatted(parameters.toArray());
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
