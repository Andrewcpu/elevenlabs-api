package net.andrewcpu.elevenlabs.requests.history;

import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.requests.GetRequest;

import java.util.HashMap;
import java.util.Map;

public class GetHistoryRequest extends GetRequest<History> {
	private int pageSize;
	private String startAfterHistoryId;

	public GetHistoryRequest() {
		this(100, null);
	}

	public GetHistoryRequest(String startAfterHistoryId) {
		this(100, startAfterHistoryId);
	}

	public GetHistoryRequest(int pageSize, String startAfterHistoryId) {
		super("v1/history", History.class);
		this.pageSize = pageSize;
		this.startAfterHistoryId = startAfterHistoryId;
	}

	@Override
	public Map<String, String> getQueryParameters() {
		Map<String, String> params = new HashMap<>();
		params.put("page_size", String.valueOf(pageSize));
		if(startAfterHistoryId != null) {
			params.put("start_after_history_item_id", startAfterHistoryId);
		}
		return params;
	}
}
