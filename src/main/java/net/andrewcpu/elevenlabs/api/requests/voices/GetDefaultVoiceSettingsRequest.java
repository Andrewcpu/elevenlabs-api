package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

public class GetDefaultVoiceSettingsRequest extends ElevenLabsRequest<VoiceSettings> {
	public GetDefaultVoiceSettingsRequest() {
		super(HTTPMethod.GET, new ResultTransformerAdapter<VoiceSettings>(){
			@Override
			public VoiceSettings transform(JSONObject object) {
				return VoiceSettings.fromJSON(object);
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/settings/default";
	}
}
