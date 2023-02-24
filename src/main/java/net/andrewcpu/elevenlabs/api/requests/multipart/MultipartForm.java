package net.andrewcpu.elevenlabs.api.requests.multipart;

import java.io.*;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MultipartForm {
	private List<MultipartFormContent> items;
	public MultipartForm() {
		items = new ArrayList<>();
	}

	public List<MultipartFormContent> getItems() {
		return items;
	}

	public void push(MultipartFormContent formContent){
		items.add(formContent );
	}
}
