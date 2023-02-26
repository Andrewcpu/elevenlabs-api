package net.andrewcpu.elevenlabs.api.net.transformers;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsResponse;
import org.json.simple.JSONObject;

public abstract class ResultTransformer<T> {
	public abstract T transform(JSONObject object);
	public abstract T transform(String object);
	public abstract T transform();
	public abstract T transform(ElevenLabsResponse<T> response);
}
