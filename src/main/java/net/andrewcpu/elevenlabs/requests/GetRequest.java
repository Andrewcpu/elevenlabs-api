package net.andrewcpu.elevenlabs.requests;

import net.andrewcpu.elevenlabs.enums.HttpRequestType;

public abstract class GetRequest<T> extends ElevenLabsRequest<T> {
	public GetRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.GET, endpoint, clazz);
	}
}
