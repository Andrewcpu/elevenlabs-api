package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
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
