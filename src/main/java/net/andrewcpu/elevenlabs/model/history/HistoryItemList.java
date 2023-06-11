package net.andrewcpu.elevenlabs.model.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class HistoryItemList extends ElevenModel {
	@JsonProperty("history_item_ids")
	private List<String> historyIds;

	public HistoryItemList(List<String> historyIds) {
		this.historyIds = historyIds;
	}

	public HistoryItemList() {
	}

	@JsonIgnore
	public List<String> getHistoryIds() {
		return historyIds;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "HistoryItemList{" +
				"historyIds=" + historyIds +
				'}';
	}
}
