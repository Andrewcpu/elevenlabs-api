package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.elements.VoiceSettings;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.requests.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

import java.util.List;

public class UpdateVoiceSettingsRequest extends ElevenLabsRequest<String> {
	public UpdateVoiceSettingsRequest(String voiceId, VoiceSettings settings){
		super(List.of(voiceId), settings.toJSON(), HTTPMethod.POST, new ResultTransformerAdapter<String>(){
			@Override
			public String transform(String object) {
				return object;
			}
		});

	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s/settings/edit";
	}
}
