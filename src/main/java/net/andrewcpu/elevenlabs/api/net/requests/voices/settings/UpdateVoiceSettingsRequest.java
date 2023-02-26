package net.andrewcpu.elevenlabs.api.net.requests.voices.settings;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import org.json.simple.JSONObject;

import java.util.List;

public class UpdateVoiceSettingsRequest extends ElevenLabsPostRequest<JSONObject> {
	public UpdateVoiceSettingsRequest(String voiceId, VoiceSettings settings){
		super(List.of(voiceId), settings.toJSON(), RequestTransformer.IN_OUT_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/settings/edit";
	}
}
