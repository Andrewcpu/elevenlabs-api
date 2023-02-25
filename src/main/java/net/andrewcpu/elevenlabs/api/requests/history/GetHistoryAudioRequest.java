package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.io.File;
import java.util.List;

public class GetHistoryAudioRequest extends ElevenLabsGetRequest<File> {
	public GetHistoryAudioRequest(String historyId, File outputFile) {
		super(List.of(historyId), new FilePingPongTransformer(outputFile));
		responseType = (ResponseType.FILE_STREAM);
		outputFilePath = (outputFile);
	}

	@Override
	public String getEndpoint() {
		return "history/{historyItemId}/audio";
	}
}
