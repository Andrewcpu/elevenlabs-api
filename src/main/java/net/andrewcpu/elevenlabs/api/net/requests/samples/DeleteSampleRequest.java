package net.andrewcpu.elevenlabs.api.net.requests.samples;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsDeleteRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONObject;

import java.util.List;

public class DeleteSampleRequest extends ElevenLabsDeleteRequest<JSONObject> {
	public DeleteSampleRequest(String voiceId, String sampleId) {
		super(List.of(voiceId, sampleId), RequestTransformer.IN_OUT_TRANSFORMER);
		responseType = (ResponseType.JSON);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/samples/{sampleId}";
	}
}
