package net.andrewcpu.elevenlabs.api.net.requests.voices;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;

import java.util.List;

public class GetVoicesRequest extends ElevenLabsGetRequest<List<Voice>> {
	public GetVoicesRequest() {
		super(RequestTransformer.VOICE_LIST_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices";
	}
}
