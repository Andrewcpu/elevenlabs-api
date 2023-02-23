package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.elements.Voice;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.requests.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetVoicesRequest extends ElevenLabsRequest<List<Voice>> {
	public GetVoicesRequest() {
		super(null, null, HTTPMethod.GET, new ResultTransformerAdapter<List<Voice>>() {
			@Override
			public List<Voice> transform(JSONObject object) {
				JSONArray voiceArray = (JSONArray) object.get("voices");
				List<Voice> voices = new ArrayList<Voice>();

				for (int i = 0; i < voiceArray.size(); i++) {
					JSONObject voiceJson = (JSONObject) voiceArray.get(i);
					voices.add(Voice.fromJSON(voiceJson));
				}

				return voices;
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/voices";
	}
}
