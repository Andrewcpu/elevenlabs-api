package net.andrewcpu.elevenlabs.requests.samples;

import net.andrewcpu.elevenlabs.requests.GetRequest;

import java.io.File;

public class GetSampleRequest extends GetRequest<File> {
	public GetSampleRequest(String voiceId, String sampleId) {
		super("v1/voices/" + voiceId + "/samples/" + sampleId + "/audio", File.class);
	}
}
