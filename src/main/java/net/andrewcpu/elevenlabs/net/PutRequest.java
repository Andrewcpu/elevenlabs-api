package net.andrewcpu.elevenlabs.net;

import net.andrewcpu.elevenlabs.HttpRequestType;

public abstract class PutRequest<T> extends ElevenRequest<T> {
	public PutRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.PUT, endpoint, clazz);
	}
}
