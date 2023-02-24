package net.andrewcpu.elevenlabs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class MultipartUtil {
	public static void addFormField(String name, String value, String boundary, HttpURLConnection connection) throws IOException {
		String header = "--" + boundary + "\r\n" +
				"Content-Disposition: form-data; name=\"" + name + "\"\r\n\r\n";
		connection.getOutputStream().write(header.getBytes(StandardCharsets.UTF_8));
		connection.getOutputStream().write(value.getBytes(StandardCharsets.UTF_8));
		connection.getOutputStream().write("\r\n".getBytes(StandardCharsets.UTF_8));
	}

	public static void addFilePart(String fieldName, String fileName, File file, String boundary, HttpURLConnection connection) throws IOException {
		String header = "--" + boundary + "\r\n" +
				"Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"\r\n" +
				"Content-Type: " + URLConnection.guessContentTypeFromName(fileName) + "\r\n\r\n";
		connection.getOutputStream().write(header.getBytes(StandardCharsets.UTF_8));

		try (InputStream fileStream = new FileInputStream(file)) {
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fileStream.read(buffer)) != -1) {
				connection.getOutputStream().write(buffer, 0, bytesRead);
			}
		}

		connection.getOutputStream().write("\r\n".getBytes(StandardCharsets.UTF_8));
	}
}
