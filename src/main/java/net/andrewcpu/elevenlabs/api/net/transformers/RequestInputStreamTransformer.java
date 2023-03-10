package net.andrewcpu.elevenlabs.api.net.transformers;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsResponse;

import java.io.InputStream;

public class RequestInputStreamTransformer extends ResultTransformerAdapter<InputStream> {

	@Override
	public InputStream transform(ElevenLabsResponse<InputStream> response) {
		return response.successStream;
	}

	@Override
	public InputStream transform() {
		return null;
	}
}
