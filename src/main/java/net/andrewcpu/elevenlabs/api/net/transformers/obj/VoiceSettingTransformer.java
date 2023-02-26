package net.andrewcpu.elevenlabs.api.net.transformers.obj;

import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import org.json.simple.JSONObject;

public class VoiceSettingTransformer extends ResultTransformerAdapter<VoiceSettings> {
	@Override
	public VoiceSettings transform(JSONObject object) {
		return VoiceSettings.fromJSON(object);
	}
}
