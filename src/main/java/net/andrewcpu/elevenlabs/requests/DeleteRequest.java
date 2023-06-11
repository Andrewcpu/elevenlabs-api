package net.andrewcpu.elevenlabs.requests;

import net.andrewcpu.elevenlabs.HttpRequestType;

public abstract class DeleteRequest<T> extends ElevenLabsRequest<T> {
	public DeleteRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.DELETE, endpoint, clazz);
	}
}
