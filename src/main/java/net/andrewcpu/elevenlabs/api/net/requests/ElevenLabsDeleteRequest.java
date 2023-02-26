package net.andrewcpu.elevenlabs.api.net.requests;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

import java.util.List;

public abstract class ElevenLabsDeleteRequest<T> extends ElevenLabsRequest<T> {
	public ElevenLabsDeleteRequest(List<String> parameters, JSONObject body, ResultTransformer<T> resultTransformer) {
		super(parameters, body, HTTPMethod.DELETE, resultTransformer);
	}

	public ElevenLabsDeleteRequest(JSONObject body, ResultTransformer<T> resultTransformer) {
		super(body, HTTPMethod.DELETE, resultTransformer);
	}


	public ElevenLabsDeleteRequest(JSONObject body) {
		super(body, HTTPMethod.DELETE);
	}

	public ElevenLabsDeleteRequest(List<String> parameters) {
		super(parameters, HTTPMethod.DELETE);
	}

	public ElevenLabsDeleteRequest(List<String> parameters, ResultTransformer<T> resultTransformer) {
		super(parameters, HTTPMethod.DELETE, resultTransformer);
	}

	public ElevenLabsDeleteRequest() {
		super(HTTPMethod.DELETE);
	}

	public ElevenLabsDeleteRequest(ResultTransformer<T> resultTransformer) {
		super(HTTPMethod.DELETE, resultTransformer);
	}
}
