package net.andrewcpu.elevenlabs.requests.history;

import net.andrewcpu.elevenlabs.model.history.HistoryItemList;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PostDownloadHistoryItemsRequest extends PostRequest<File> {
	private final String[] historyItemIds;
	public PostDownloadHistoryItemsRequest(String... historyItemIds) {
		super("v1/history/download", File.class);
		this.historyItemIds = historyItemIds;
	}

	@Override
	public Object getPayload() {
		return new HistoryItemList(Arrays.stream(this.historyItemIds).collect(Collectors.toList()));
	}
}
