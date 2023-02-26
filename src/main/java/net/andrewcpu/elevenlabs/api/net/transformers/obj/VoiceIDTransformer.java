package net.andrewcpu.elevenlabs.api.net.transformers.obj;

import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformerAdapter;
import org.json.simple.JSONObject;

public class VoiceIDTransformer extends ResultTransformerAdapter<String> {

	@Override
	public String transform(JSONObject object) {
		return object.get("voice_id").toString();
	}
}
