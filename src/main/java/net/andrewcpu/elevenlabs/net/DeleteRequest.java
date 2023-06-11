package net.andrewcpu.elevenlabs.net;

import net.andrewcpu.elevenlabs.HttpRequestType;

public abstract class DeleteRequest<T> extends ElevenRequest<T> {
	public DeleteRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.DELETE, endpoint, clazz);
	}
}
