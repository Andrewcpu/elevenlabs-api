package net.andrewcpu.elevenlabs.net;

import net.andrewcpu.elevenlabs.HttpRequestType;

public abstract class GetRequest<T> extends ElevenRequest<T> {
	public GetRequest(String endpoint, Class<T> clazz) {
		super(HttpRequestType.GET, endpoint, clazz);
	}
}
