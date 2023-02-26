package net.andrewcpu.elevenlabs.api.net.requests;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

import java.util.List;

public abstract class ElevenLabsGetRequest<T> extends ElevenLabsRequest<T> {
	public ElevenLabsGetRequest(List<String> parameters, JSONObject body,  ResultTransformer<T> resultTransformer) {
		super(parameters, body, HTTPMethod.GET, resultTransformer);
	}
	public ElevenLabsGetRequest(JSONObject body, ResultTransformer<T> resultTransformer) {
		super(body, HTTPMethod.GET, resultTransformer);
	}

	public ElevenLabsGetRequest(JSONObject body) {
		super(body, HTTPMethod.GET);
	}

	public ElevenLabsGetRequest(List<String> parameters) {
		super(parameters, HTTPMethod.GET);
	}

	public ElevenLabsGetRequest(List<String> parameters,  ResultTransformer<T> resultTransformer) {
		super(parameters, HTTPMethod.GET, resultTransformer);
	}

	public ElevenLabsGetRequest() {
		super(HTTPMethod.GET);
	}

	public ElevenLabsGetRequest( ResultTransformer<T> resultTransformer) {
		super(HTTPMethod.GET, resultTransformer);
	}
}
