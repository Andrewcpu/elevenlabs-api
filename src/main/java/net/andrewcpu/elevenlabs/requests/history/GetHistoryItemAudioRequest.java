package net.andrewcpu.elevenlabs.requests.history;

import net.andrewcpu.elevenlabs.requests.GetRequest;

import java.io.File;

public class GetHistoryItemAudioRequest extends GetRequest<File> {
	public GetHistoryItemAudioRequest(String historyItemId) {
		super("v1/history/" + historyItemId + "/audio", File.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
