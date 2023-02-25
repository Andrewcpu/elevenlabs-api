package net.andrewcpu.elevenlabs.api.requests.voices.settings;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;

import java.util.List;

public class UpdateVoiceSettingsRequest extends ElevenLabsPostRequest<String> {
	public UpdateVoiceSettingsRequest(String voiceId, VoiceSettings settings){
		super(List.of(voiceId), settings.toJSON(), RequestTransformer.STRING_RESULT_TRANSFORMER);

	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/settings/edit";
	}
}
