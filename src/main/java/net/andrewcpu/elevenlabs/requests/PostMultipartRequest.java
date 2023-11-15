package net.andrewcpu.elevenlabs.requests;

import java.util.HashMap;
import java.util.Map;

public abstract class PostMultipartRequest<T> extends PostRequest<T> {
	public PostMultipartRequest(String endpoint, Class<T> clazz) {
		super(endpoint, clazz);
	}


	public abstract Map<String, Object> getMultipartParts(Map<String, Object> map);

	@Override
	public Object getPayload() {
		return getMultipartParts(new HashMap<>());
	}
}
