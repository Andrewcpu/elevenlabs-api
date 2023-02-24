package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.elements.History;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

public class GetHistoryRequest extends ElevenLabsRequest<History> {
	public GetHistoryRequest() {
		super(null, null, HTTPMethod.GET, new ResultTransformerAdapter<History>(){
			@Override
			public History transform(JSONObject object) {
				return History.fromJSON(object);
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/history";
	}
}
