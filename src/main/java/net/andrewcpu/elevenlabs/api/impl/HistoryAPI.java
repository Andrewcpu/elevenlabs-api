package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import net.andrewcpu.elevenlabs.requests.history.*;

import java.io.File;

public class HistoryAPI extends ElevenLabsAPI {

	public History getHistory() {
		return sendRequest(new GetHistoryRequest());
	}

	public History getHistory(int pageSize, String afterHistoryId) {
		return sendRequest(new GetHistoryRequest(pageSize, afterHistoryId));
	}

	public History getHistory(String afterHistoryId) {
		return sendRequest(new GetHistoryRequest(afterHistoryId));
	}

	public HistoryItem getHistoryItem(String historyItemId) {
		return sendRequest(new GetHistoryItemByIdRequest(historyItemId));
	}

	public String deleteHistoryItem(String historyItemId) {
		return sendRequest(new DeleteHistoryItemRequest(historyItemId));
	}

	public File getHistoryItemAudio(String historyItemId) {
		return sendRequest(new GetHistoryItemAudioRequest(historyItemId));
	}

	public File getHistoryItemAudio(String... historyItemIds) {
		return sendRequest(new PostDownloadHistoryItemsRequest(historyItemIds));
	}
}
