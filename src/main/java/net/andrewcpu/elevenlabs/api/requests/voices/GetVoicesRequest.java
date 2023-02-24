package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.VoiceListTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

import java.util.List;

public class GetVoicesRequest extends ElevenLabsRequest<List<Voice>> {
	public GetVoicesRequest() {
		super(HTTPMethod.GET, new VoiceListTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/voices";
	}
}
