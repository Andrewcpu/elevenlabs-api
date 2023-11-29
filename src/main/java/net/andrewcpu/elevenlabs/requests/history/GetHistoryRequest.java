package net.andrewcpu.elevenlabs.requests.history;

import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.requests.GetRequest;

import java.util.HashMap;
import java.util.Map;

import static net.andrewcpu.elevenlabs.model.history.History.DEFAULT_HISTORY_PAGE_SIZE;

public class GetHistoryRequest extends GetRequest<History> {
	private final int pageSize;
	private final String startAfterHistoryId;

	public GetHistoryRequest() {
		this(DEFAULT_HISTORY_PAGE_SIZE, null);
	}

	public GetHistoryRequest(String startAfterHistoryId) {
		this(DEFAULT_HISTORY_PAGE_SIZE, startAfterHistoryId);
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
