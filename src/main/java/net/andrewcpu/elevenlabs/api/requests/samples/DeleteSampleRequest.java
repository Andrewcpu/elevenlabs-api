package net.andrewcpu.elevenlabs.api.requests.samples;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.requests.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.util.List;

public class DeleteSampleRequest extends ElevenLabsRequest<String> {
	public DeleteSampleRequest(String voiceId, String sampleId) {
		super(List.of(voiceId, sampleId), null, HTTPMethod.DELETE, new ResultTransformerAdapter<String>() {
			@Override
			public String transform(String object) {
				return object;
			}
		});
		setResponseType(ResponseType.STRING);
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s/samples/%s";
	}
}
