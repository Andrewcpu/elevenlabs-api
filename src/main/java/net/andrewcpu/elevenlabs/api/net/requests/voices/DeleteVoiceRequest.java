package net.andrewcpu.elevenlabs.api.net.requests.voices;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsDeleteRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import org.json.simple.JSONObject;

import java.util.List;

public class DeleteVoiceRequest extends ElevenLabsDeleteRequest<JSONObject> {
	public DeleteVoiceRequest(String voiceId) {
		super(List.of(voiceId), RequestTransformer.IN_OUT_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}";
	}
}
