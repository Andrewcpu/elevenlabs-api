package net.andrewcpu.elevenlabs.net.history;

import net.andrewcpu.elevenlabs.model.history.HistoryItemList;
import net.andrewcpu.elevenlabs.net.PostRequest;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PostDownloadHistoryItemsRequest extends PostRequest<File> {
	private String[] historyItemIds;
	public PostDownloadHistoryItemsRequest(String... historyItemIds) {
		super("v1/history/download", File.class);
		this.historyItemIds = historyItemIds;
	}

	@Override
	public Object getPayload() {
		return new HistoryItemList(Arrays.stream(this.historyItemIds).collect(Collectors.toList()));
	}
}
