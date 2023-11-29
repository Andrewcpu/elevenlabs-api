package net.andrewcpu.elevenlabs.model.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class History extends ElevenModel {
	public static final int DEFAULT_HISTORY_PAGE_SIZE = 100;
	public static History get() {
		return ElevenLabs.getHistoryAPI().getHistory();
	}
	public static History get(String afterHistoryId) {
		return ElevenLabs.getHistoryAPI().getHistory(afterHistoryId);
	}
	public static History get(int pageSize, String afterHistoryId) {
		return ElevenLabs.getHistoryAPI().getHistory(pageSize, afterHistoryId);
	}

	public static History get(int pageSize) {
		return ElevenLabs.getHistoryAPI().getHistory(pageSize, null);
	}



	@JsonProperty("history")
	private List<HistoryItem> historyItems;

	@JsonProperty("last_history_item_id")
	private String lastHistoryItemId;

	@JsonProperty("has_more")
	private boolean hasMore;

	public History(List<HistoryItem> historyItems) {
		this.historyItems = historyItems;
	}

	public History() {
	}

	@JsonIgnore
	public HistoryItem getHistoryItem(String id) {
		for (HistoryItem item : historyItems) {
			if (item.getHistoryItemId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	@JsonIgnore
	public List<HistoryItem> getHistoryItems() {
		return historyItems;
	}

	@JsonIgnore
	public String getLastHistoryItemId() {
		return lastHistoryItemId;
	}

	@JsonIgnore
	public boolean isHasMore() {
		return hasMore;
	}

	public File downloadHistory(String... historyIds) {
		return ElevenLabs.getHistoryAPI().getHistoryItemAudio(historyIds);
	}

	public File downloadHistory(HistoryItem... items) {
		return ElevenLabs.getHistoryAPI().getHistoryItemAudio(Arrays.stream(items).map(HistoryItem::getHistoryItemId).toArray(String[]::new));
	}

	public Optional<History> next(int pageSize) {
		if(!hasMore) {
			return Optional.empty();
		}
		return Optional.of(ElevenLabs.getHistoryAPI().getHistory(pageSize, lastHistoryItemId));
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "History{" +
				"historyItems=" + historyItems +
				", lastHistoryItemId='" + lastHistoryItemId + '\'' +
				", hasMore=" + hasMore +
				'}';
	}
}
