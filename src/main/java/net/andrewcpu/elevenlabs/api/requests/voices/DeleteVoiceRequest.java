package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.requests.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

import java.util.List;

public class DeleteVoiceRequest extends ElevenLabsRequest<String> {
	public DeleteVoiceRequest(String voiceId) {
		super(List.of(voiceId), null, HTTPMethod.DELETE, new ResultTransformerAdapter<String>(){
			@Override
			public String transform(String object) {
				return object;
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "/v1/voices/%s";
	}
}
