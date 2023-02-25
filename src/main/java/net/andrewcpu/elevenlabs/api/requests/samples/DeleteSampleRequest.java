package net.andrewcpu.elevenlabs.api.requests.samples;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsDeleteRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.util.List;

public class DeleteSampleRequest extends ElevenLabsDeleteRequest<String> {
	public DeleteSampleRequest(String voiceId, String sampleId) {
		super(List.of(voiceId, sampleId), RequestTransformer.STRING_RESULT_TRANSFORMER);
		responseType = (ResponseType.STRING);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/samples/{sampleId}";
	}
}
