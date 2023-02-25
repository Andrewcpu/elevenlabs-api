package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsDeleteRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.util.List;

public class DeleteHistoryItemRequest extends ElevenLabsDeleteRequest<String> {
	public DeleteHistoryItemRequest(String historyId) {
		super(List.of(historyId), RequestTransformer.STRING_RESULT_TRANSFORMER);
		responseType = (ResponseType.STRING);
	}

	@Override
	public String getEndpoint() {
		return "history/{historyItemId}";
	}
}
