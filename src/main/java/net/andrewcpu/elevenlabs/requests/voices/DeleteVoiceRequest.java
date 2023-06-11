package net.andrewcpu.elevenlabs.requests.voices;

import net.andrewcpu.elevenlabs.requests.DeleteRequest;

public class DeleteVoiceRequest extends DeleteRequest<String> {
	public DeleteVoiceRequest(String voiceId) {
		super("v1/voices/" + voiceId, String.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
