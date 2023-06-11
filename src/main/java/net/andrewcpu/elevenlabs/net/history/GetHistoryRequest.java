package net.andrewcpu.elevenlabs.net.history;

import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetHistoryRequest extends GetRequest<History> {
	public GetHistoryRequest() {
		super("v1/history", History.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
