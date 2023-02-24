package net.andrewcpu.elevenlabs.api.multipart;

import java.io.File;

public class MultipartFile extends MultipartFormContent {
	private final File file;
	public MultipartFile(String name, File file) {
		super(name, file);
		this.file = file;
	}

	public File getFile() {
		return file;
	}
}
