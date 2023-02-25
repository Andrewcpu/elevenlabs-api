package net.andrewcpu.elevenlabs.api.requests;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

import java.util.List;

public abstract class ElevenLabsPostRequest<T> extends ElevenLabsRequest<T> {
	public ElevenLabsPostRequest(List<String> parameters, JSONObject body, ResultTransformer<T> resultTransformer) {
		super(parameters, body, HTTPMethod.POST, resultTransformer);
	}

	public ElevenLabsPostRequest(JSONObject body) {
		super(body, HTTPMethod.POST);
	}

	public ElevenLabsPostRequest(JSONObject body, ResultTransformer<T> resultTransformer) {
		super(body, HTTPMethod.POST, resultTransformer);
	}

	public ElevenLabsPostRequest(List<String> parameters) {
		super(parameters, HTTPMethod.POST);
	}

	public ElevenLabsPostRequest(List<String> parameters, ResultTransformer<T> resultTransformer) {
		super(parameters, HTTPMethod.POST, resultTransformer);
	}

	public ElevenLabsPostRequest() {
		super(HTTPMethod.POST);
	}

	public ElevenLabsPostRequest(ResultTransformer<T> resultTransformer) {
		super(HTTPMethod.POST, resultTransformer);
	}
}
