package net.andrewcpu.elevenlabs.api.transformers;

import org.json.simple.JSONObject;

public abstract class ResultTransformer<T> {
	public abstract T transform(JSONObject object);
	public abstract T transform(String object);
	public abstract T transform();
}
