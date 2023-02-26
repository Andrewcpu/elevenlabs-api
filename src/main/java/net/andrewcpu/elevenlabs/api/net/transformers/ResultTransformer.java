package net.andrewcpu.elevenlabs.api.net.transformers;

import org.json.simple.JSONObject;

public abstract class ResultTransformer<T> {
	public abstract T transform(JSONObject object);
	public abstract T transform(String object);
	public abstract T transform();
}
