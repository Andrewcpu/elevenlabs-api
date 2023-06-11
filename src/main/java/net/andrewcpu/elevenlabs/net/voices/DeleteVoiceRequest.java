package net.andrewcpu.elevenlabs.net.voices;

import net.andrewcpu.elevenlabs.net.DeleteRequest;

public class DeleteVoiceRequest extends DeleteRequest<String> {
	public DeleteVoiceRequest(String voiceId) {
		super("v1/voices/" + voiceId, String.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
