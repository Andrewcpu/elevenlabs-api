package net.andrewcpu.elevenlabs.requests.voices;

import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.requests.GetRequest;

import java.util.HashMap;
import java.util.Map;

public class GetVoiceRequest extends GetRequest<Voice> {
	private final boolean withSettings;
	public GetVoiceRequest(String voiceId) {
		this(voiceId,  true);
	}



	public GetVoiceRequest(String voiceId, boolean withSettings) {
		super( "v1/voices/" + voiceId, Voice.class);
		this.withSettings = withSettings;
	}

	@Override
	public Map<String, String> getQueryParameters() {
		Map<String, String> payload = new HashMap<>();
		payload.put("with_settings", String.valueOf(withSettings));
		return payload;
	}

}
