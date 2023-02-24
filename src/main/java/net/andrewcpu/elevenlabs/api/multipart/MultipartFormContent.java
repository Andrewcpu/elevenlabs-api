package net.andrewcpu.elevenlabs.api.multipart;

public class MultipartFormContent {
	private String name;
	private String filename;
	private String value;

	public MultipartFormContent(String name, String filename, String value) {
		this.name = name;
		this.filename = filename;
		this.value = value;
	}

	public MultipartFormContent(String name, String value) {
		this.name = name;
		this.value = value;
		this.filename = null;
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
