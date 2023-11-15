package net.andrewcpu.elevenlabs.requests.samples;

import net.andrewcpu.elevenlabs.requests.DeleteRequest;

public class DeleteSampleRequest extends DeleteRequest<String> {
	public DeleteSampleRequest(String voiceId, String sampleId) {
		super("v1/voices/" + voiceId + "/samples/" + sampleId, String.class);
	}
}
