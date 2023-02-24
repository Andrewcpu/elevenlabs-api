package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.StringPingPongTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

import java.util.List;

public class DeleteVoiceRequest extends ElevenLabsRequest<String> {
	public DeleteVoiceRequest(String voiceId) {
		super(List.of(voiceId), HTTPMethod.DELETE, new StringPingPongTransformer());
	}

	@Override
	public String getEndpoint() {
		return "/v1/voices/%s";
	}
}
