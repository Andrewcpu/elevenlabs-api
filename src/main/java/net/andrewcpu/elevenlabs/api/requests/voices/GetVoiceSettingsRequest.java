package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

import java.util.List;

public class GetVoiceSettingsRequest extends ElevenLabsRequest<VoiceSettings> {
	public GetVoiceSettingsRequest(String voiceId) {
		super(List.of(voiceId), HTTPMethod.GET, new ResultTransformerAdapter<VoiceSettings>() {
			@Override
			public VoiceSettings transform(JSONObject object) {
				return VoiceSettings.fromJSON(object);
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s/settings";
	}
}
