package net.andrewcpu.elevenlabs.net.voices;

import net.andrewcpu.elevenlabs.model.response.VoiceModelResponse;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetVoicesRequest extends GetRequest<VoiceModelResponse> {
	public GetVoicesRequest() {
		super("v1/voices", VoiceModelResponse.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
