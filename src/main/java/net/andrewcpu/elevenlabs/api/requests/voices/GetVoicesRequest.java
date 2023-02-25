package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
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
