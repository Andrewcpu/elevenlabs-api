package net.andrewcpu.elevenlabs.requests;

import net.andrewcpu.elevenlabs.HttpRequestType;

public abstract class PostRequest<T> extends ElevenLabsRequest<T> {
	public PostRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.POST, endpoint, clazz);
	}
}
