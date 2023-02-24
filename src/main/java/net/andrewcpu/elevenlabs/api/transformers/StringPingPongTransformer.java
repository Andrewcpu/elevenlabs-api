package net.andrewcpu.elevenlabs.api.transformers;

public class StringPingPongTransformer extends ResultTransformerAdapter<String> {
	@Override
	public String transform(String object) {
		return object;
	}
}
