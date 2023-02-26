package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.api.net.requests.history.DeleteHistoryItemRequest;
import net.andrewcpu.elevenlabs.api.net.requests.history.DownloadHistoryRequest;
import net.andrewcpu.elevenlabs.api.net.requests.history.GetHistoryAudioRequest;
import net.andrewcpu.elevenlabs.api.net.requests.history.GetHistoryRequest;
import net.andrewcpu.elevenlabs.elements.voice.History;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;

import java.io.File;
import java.util.List;

import static net.andrewcpu.elevenlabs.ElevenLabsAPI.getRequestResult;

public class HistoryAPI {
	public static History getHistory() throws ElevenLabsException {
		return getRequestResult(new GetHistoryRequest());
	}

	public static File downloadHistory(List<String> historyIds, File outputFile) throws ElevenLabsException {
		return getRequestResult(new DownloadHistoryRequest(historyIds, outputFile));
	}

	public static File getHistoryItemAudio(History.HistoryItem historyItem, File outputFile) throws ElevenLabsException {
		return getRequestResult(new GetHistoryAudioRequest(historyItem.getHistoryItemId(), outputFile));
	}

	public static String deleteHistoryItem(History.HistoryItem historyItem) throws ElevenLabsException {
		return getRequestResult(new DeleteHistoryItemRequest(historyItem.getHistoryItemId()));
	}
}
