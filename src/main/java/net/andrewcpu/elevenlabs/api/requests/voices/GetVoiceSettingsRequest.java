package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.VoiceSettingTransformer;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

import java.util.List;

public class GetVoiceSettingsRequest extends ElevenLabsRequest<VoiceSettings> {
	public GetVoiceSettingsRequest(String voiceId) {
		super(List.of(voiceId), HTTPMethod.GET, new VoiceSettingTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s/settings";
	}
}
