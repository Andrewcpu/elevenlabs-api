package net.andrewcpu.elevenlabs.api.net.multipart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipartForm {
	private final List<MultipartFormContent> items;
	public MultipartForm() {
		items = new ArrayList<>();
	}

	public List<MultipartFormContent> getItems() {
		return items;
	}


	public void push(MultipartFormContent... formContent) {
		items.addAll(Arrays.asList(formContent));
	}
}
