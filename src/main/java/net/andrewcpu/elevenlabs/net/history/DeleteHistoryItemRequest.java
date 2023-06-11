package net.andrewcpu.elevenlabs.net.history;

import net.andrewcpu.elevenlabs.net.DeleteRequest;

public class DeleteHistoryItemRequest extends DeleteRequest<String> {
	public DeleteHistoryItemRequest(String historyItemId) {
		super("v1/history/" + historyItemId, String.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
