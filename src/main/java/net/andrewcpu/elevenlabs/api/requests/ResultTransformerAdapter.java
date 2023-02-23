package net.andrewcpu.elevenlabs.api.requests;

import org.json.simple.JSONObject;

public class ResultTransformerAdapter<T> extends ResultTransformer<T> {

	@Override
	public T transform(JSONObject object) {
		throw new UnsupportedOperationException("transform(JSONObject object) is not defined.");
	}

	@Override
	public T transform(String object) {
		throw new UnsupportedOperationException("transform(String object) is not defined.");
	}

	@Override
	public T transform() {
		throw new UnsupportedOperationException("transform() is not defined.");
	}
}
