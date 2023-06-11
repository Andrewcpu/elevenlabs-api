package net.andrewcpu.elevenlabs.requests.tts;

import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.InputStream;

public class PostTextToSpeechStreamedRequest extends PostRequest<InputStream> {
	private TextToSpeechRequest request;
	public PostTextToSpeechStreamedRequest(String voiceId, TextToSpeechRequest request) {
		super("v1/text-to-speech/" + voiceId, InputStream.class);
		this.request = request;
	}

	@Override
	public Object getPayload() {
		return request;
	}
}
