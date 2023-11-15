package net.andrewcpu.elevenlabs.requests.history;

import net.andrewcpu.elevenlabs.requests.DeleteRequest;

public class DeleteHistoryItemRequest extends DeleteRequest<String> {
	public DeleteHistoryItemRequest(String historyItemId) {
		super("v1/history/" + historyItemId, String.class);
	}
}
