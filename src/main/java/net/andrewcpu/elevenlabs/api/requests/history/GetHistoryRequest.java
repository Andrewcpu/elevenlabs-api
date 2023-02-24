package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.HistoryTransformer;
import net.andrewcpu.elevenlabs.elements.voice.History;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

public class GetHistoryRequest extends ElevenLabsRequest<History> {
	public GetHistoryRequest() {
		super(HTTPMethod.GET, new HistoryTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/history";
	}
}
