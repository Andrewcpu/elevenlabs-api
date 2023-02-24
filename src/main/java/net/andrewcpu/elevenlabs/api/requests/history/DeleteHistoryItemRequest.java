package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.StringPingPongTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;

import java.util.List;

public class DeleteHistoryItemRequest extends ElevenLabsRequest<String> {
	public DeleteHistoryItemRequest(String historyId) {
		super(List.of(historyId), null, HTTPMethod.DELETE, new StringPingPongTransformer());
		responseType = (ResponseType.STRING);
	}

	@Override
	public String getEndpoint() {
		return "v1/history/%s";
	}
}