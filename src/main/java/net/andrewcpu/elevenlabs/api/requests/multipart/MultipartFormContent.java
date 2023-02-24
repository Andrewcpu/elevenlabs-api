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

	public String getFilename() {
		return filename;
	}


	public String getValue() {
		return value;
	}

}
