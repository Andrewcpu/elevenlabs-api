package net.andrewcpu.elevenlabs.api.net.transformers;

import net.andrewcpu.elevenlabs.util.DebugLogger;

public class StringPingPongTransformer extends ResultTransformerAdapter<String> {
	@Override
	public String transform(String object) {
		DebugLogger.log(getClass(),object);
		return object;
	}
}
