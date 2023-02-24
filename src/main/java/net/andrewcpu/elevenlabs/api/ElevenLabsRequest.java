package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.api.requests.ResultTransformer;
import net.andrewcpu.elevenlabs.api.requests.multipart.MultipartForm;
import net.andrewcpu.elevenlabs.enums.ContentType;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public abstract class ElevenLabsRequest<T> {
	private List<String> parameters;
	private JSONObject body;
	private HTTPMethod method;
	private ResponseType responseType = ResponseType.JSON;
	private File outputFilePath;
	private ResultTransformer<T> resultTransformer;
	private List<File> files;
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

	public List<File> getFiles() {
		return files;
	}

	protected void setFiles(List<File> files) {
		this.files = files;
	}

	public MultipartForm getMultipartForm() {
		return multipartForm;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public ElevenLabsRequest(HTTPMethod method) {
		this.method = method;
	}

	public HTTPMethod getMethod() {
		return method;
	}

	public File getOutputFilePath() {
		return outputFilePath;
	}

	protected void setOutputFilePath(File outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public abstract String getEndpoint();

	public ResultTransformer<T> getResultTransformer() {
		return resultTransformer;
	}

	protected void setResultTransformer(ResultTransformer<T> resultTransformer) {
		this.resultTransformer = resultTransformer;
	}

	public String getFormattedEndpoint(){
		String endpoint = getEndpoint();
		if(parameters != null && parameters.size() > 0){
			return endpoint.formatted(parameters.toArray());
		}
		return endpoint;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public JSONObject getBody() {
		return body;
	}

	private void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	protected void setBody(JSONObject body) {
		this.body = body;
	}

	public ResponseType getResponseType() {
		return responseType;
	}

	protected void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}
}
