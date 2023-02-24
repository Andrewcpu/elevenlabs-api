package net.andrewcpu.elevenlabs.api.multipart;

import java.io.File;

public class MultipartFormContent {
	private final String name;
	private final String filename;
	private final String value;

	public MultipartFormContent(String name, File file) {
		this.name = name;
		this.filename = file.getName();
		this.value = null;
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
