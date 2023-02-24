package net.andrewcpu.elevenlabs.api.multipart;

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


	public void push(MultipartFormContent... formContent) {
		for(int i = 0; i<formContent.length; i++){
			items.add(formContent[i]);
		}
	}
}
