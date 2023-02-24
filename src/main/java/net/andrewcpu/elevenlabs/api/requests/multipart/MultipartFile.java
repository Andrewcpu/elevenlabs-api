package net.andrewcpu.elevenlabs.api.requests.multipart;

import java.io.File;
import java.net.URLConnection;

public class MultipartFile extends MultipartFormContent {

	private File file;
	public MultipartFile(String name, File file) {
		super(name, file.getName(), null,  URLConnection.guessContentTypeFromName(file.getName()));
		this.file = file;
	}

	public File getFile() {
		return file;
	}
}
