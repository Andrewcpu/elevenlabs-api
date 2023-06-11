package net.andrewcpu.elevenlabs.model.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class History extends ElevenModel {
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
