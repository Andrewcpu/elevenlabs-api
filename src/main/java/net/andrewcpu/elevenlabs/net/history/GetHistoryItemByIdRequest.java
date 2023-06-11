package net.andrewcpu.elevenlabs.net.history;

import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetHistoryItemByIdRequest extends GetRequest<HistoryItem> {
	public GetHistoryItemByIdRequest(String historyId) {
		super("v1/history/" + historyId, HistoryItem.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
