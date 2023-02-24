package net.andrewcpu.elevenlabs.api.requests.multipart;

public class MultipartFormContent {
	private String name;
	private String filename;
	private String value;
	private String contentType;

	public MultipartFormContent(String name, String filename, String value, String contentType) {
		this.name = name;
		this.filename = filename;
		this.value = value;
		this.contentType = contentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String assembleHeader(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Content-Disposition: form-data; name=\"");
		stringBuilder.append(name);
		stringBuilder.append("\";");
		if(filename != null){
			stringBuilder.append(" filename=\"");
			stringBuilder.append(filename);
			stringBuilder.append("\";");
			stringBuilder.append("\r\n");
			stringBuilder.append("Content-Type: " + contentType);
		}
		stringBuilder.append("\r\n\r\n");
		return stringBuilder.toString();
	}
}
