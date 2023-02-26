package net.andrewcpu.elevenlabs.api.net.requests.history;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.voice.History;

public class GetHistoryRequest extends ElevenLabsGetRequest<History> {
	public GetHistoryRequest() {
		super(RequestTransformer.HISTORY_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "history";
	}
}
