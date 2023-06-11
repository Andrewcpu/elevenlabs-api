package net.andrewcpu.elevenlabs.net.samples;

import net.andrewcpu.elevenlabs.net.GetRequest;

import java.io.File;

public class GetSampleRequest extends GetRequest<File> {
	public GetSampleRequest(String voiceId, String sampleId) {
		super("v1/voices/" + voiceId + "/samples/" + sampleId + "/audio", File.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
