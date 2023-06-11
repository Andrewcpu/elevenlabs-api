package net.andrewcpu.elevenlabs.net.samples;

import net.andrewcpu.elevenlabs.net.DeleteRequest;

public class DeleteSampleRequest extends DeleteRequest<String> {
	public DeleteSampleRequest(String voiceId, String sampleId) {
		super("v1/voices/" + voiceId + "/samples/" + sampleId, String.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
