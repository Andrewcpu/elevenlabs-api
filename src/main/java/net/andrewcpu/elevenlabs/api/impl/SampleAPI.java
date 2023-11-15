package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.requests.samples.DeleteSampleRequest;
import net.andrewcpu.elevenlabs.requests.samples.GetSampleRequest;

import java.io.File;

public class SampleAPI extends ElevenLabsAPI {

	public String deleteSample(String voiceId, String sampleId) {
		return sendRequest(new DeleteSampleRequest(voiceId, sampleId));
	}

	public File getAudioSample(String voiceId, String sampleId) {
		return sendRequest(new GetSampleRequest(voiceId, sampleId));
	}
}
