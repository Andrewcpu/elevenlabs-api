package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.io.File;
import java.util.List;

public class GetHistoryAudioRequest extends ElevenLabsRequest<File> {
	public GetHistoryAudioRequest(String historyId, File outputFile) {
		super(List.of(historyId), null, HTTPMethod.GET, new FilePingPongTransformer(outputFile));
		responseType = (ResponseType.FILE_STREAM);
		outputFilePath = (outputFile);
	}

	@Override
	public String getEndpoint() {
		return "v1/history/%s/audio";
	}
}
