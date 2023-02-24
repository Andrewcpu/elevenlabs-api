package net.andrewcpu.elevenlabs.api.requests.samples;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.io.File;
import java.util.List;

public class GetAudioSampleRequest extends ElevenLabsRequest<File> {
	public GetAudioSampleRequest(String voiceId, String sampleId, File outputFile) {
		super(List.of(voiceId, sampleId), null, HTTPMethod.GET, new FilePingPongTransformer(outputFile));
		responseType = (ResponseType.FILE_STREAM);
		setOutputFilePath(outputFile);
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s/samples/%s/audio";
	}
}
