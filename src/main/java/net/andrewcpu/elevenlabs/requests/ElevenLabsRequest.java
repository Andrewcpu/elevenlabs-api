package net.andrewcpu.elevenlabs.requests;

import net.andrewcpu.elevenlabs.enums.HttpRequestType;

import java.util.HashMap;
import java.util.Map;

import static net.andrewcpu.elevenlabs.util.ElevenNetworkUtil.buildQueryParameters;

public abstract class ElevenLabsRequest<T> {
	private HttpRequestType type;
	private String endpoint;
	private Class<T> responseClass;

	public ElevenLabsRequest(HttpRequestType type, String endpoint, Class<T> clazz) {
		this.type = type;
		this.endpoint = endpoint;
		this.responseClass = clazz;
	}

	public HttpRequestType getType() {
		return type;
	}

	public String getEndpoint() {
		return endpoint + "?" + buildQueryParameters(getQueryParameters());
	}

	public Map<String, String> getQueryParameters() {
		return new HashMap<>();
	}

	public Class<T> getResponseClass() {
		return responseClass;
	}

	public abstract Object getPayload();


}
