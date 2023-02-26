package net.andrewcpu.elevenlabs.api.net.requests.samples;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.io.File;
import java.util.List;

public class GetAudioSampleRequest extends ElevenLabsGetRequest<File> {
	public GetAudioSampleRequest(String voiceId, String sampleId, File outputFile) {
		super(List.of(voiceId, sampleId), new FilePingPongTransformer(outputFile));
		responseType = ResponseType.FILE_STREAM;
		outputFilePath = outputFile;
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/samples/{sampleId}/audio";
	}
}
