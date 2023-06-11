package net.andrewcpu.elevenlabs.net;

import net.andrewcpu.elevenlabs.HttpRequestType;
import net.andrewcpu.elevenlabs.util.ElevenNetworkUtil;

public abstract class ElevenRequest<T> {
	private HttpRequestType type;
	private String endpoint;
	private Class<T> responseClass;

	public ElevenRequest(HttpRequestType type, String endpoint, Class<T> clazz) {
		this.type = type;
		this.endpoint = endpoint;
		this.responseClass = clazz;
	}

	public HttpRequestType getType() {
		return type;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public Class<T> getResponseClass() {
		return responseClass;
	}

	public abstract Object getPayload();


}
