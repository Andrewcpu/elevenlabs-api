package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

import java.util.List;

public class GetVoiceRequest extends ElevenLabsRequest<Voice> {
	public GetVoiceRequest(String voiceId, boolean withSettings) {
		super(List.of(voiceId, String.valueOf(withSettings)), null, HTTPMethod.GET, new ResultTransformerAdapter<Voice>() {
			@Override
			public Voice transform(JSONObject object) {
				JSONObject voiceJson = object;
				return Voice.fromJSON(voiceJson);
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s?with_settings=%s";
	}
}
