package net.andrewcpu.elevenlabs.requests.voices;

import net.andrewcpu.elevenlabs.model.response.VoiceModelResponse;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetVoicesRequest extends GetRequest<VoiceModelResponse> {
	public GetVoicesRequest() {
		super("v1/voices", VoiceModelResponse.class);
	}
}
