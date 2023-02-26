package net.andrewcpu.elevenlabs.api.net.transformers;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsResponse;
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

	@Override
	public T transform(ElevenLabsResponse<T> response) {
		throw new UnsupportedOperationException("transform(Response response) is not defined.");
	}
}
