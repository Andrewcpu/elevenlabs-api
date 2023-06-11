package net.andrewcpu.elevenlabs.requests.history;

import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetHistoryItemByIdRequest extends GetRequest<HistoryItem> {
	public GetHistoryItemByIdRequest(String historyId) {
		super("v1/history/" + historyId, HistoryItem.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
