package net.andrewcpu.elevenlabs.requests;

import net.andrewcpu.elevenlabs.enums.HttpRequestType;

public abstract class PutRequest<T> extends ElevenLabsRequest<T> {
	public PutRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.PUT, endpoint, clazz);
	}
}
