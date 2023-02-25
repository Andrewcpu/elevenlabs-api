package net.andrewcpu.elevenlabs.api.transformers.obj;

import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import org.json.simple.JSONObject;

public class VoiceIDTransformer extends ResultTransformerAdapter<String> {
	@Override
	public String transform(JSONObject object) {
		return object.get("voice_id").toString();
	}
}
