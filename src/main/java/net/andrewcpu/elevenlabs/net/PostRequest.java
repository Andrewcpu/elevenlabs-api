package net.andrewcpu.elevenlabs.net;

import net.andrewcpu.elevenlabs.HttpRequestType;

public abstract class PostRequest<T> extends ElevenRequest<T> {
	public PostRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.POST, endpoint, clazz);
	}
}
