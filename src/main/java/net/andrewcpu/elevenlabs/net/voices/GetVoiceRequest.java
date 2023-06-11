package net.andrewcpu.elevenlabs.net.voices;

import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.net.GetRequest;

import java.util.HashMap;
import java.util.Map;

public class GetVoiceRequest extends GetRequest<Voice> {
	private boolean withSettings;
	public GetVoiceRequest(String voiceId) {
		this(voiceId,  true);
	}

	public GetVoiceRequest(String voiceId, boolean withSettings) {
		super( "v1/voices/" + voiceId, Voice.class);
		this.withSettings = withSettings;
	}

	@Override
	public Object getPayload() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("with_settings", withSettings);
		return payload;
	}
}
