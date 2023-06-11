package net.andrewcpu.elevenlabs.requests.tts;

import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.File;

public class PostTextToSpeechRequest extends PostRequest<File> {
	private TextToSpeechRequest request;
	public PostTextToSpeechRequest(String voiceId, TextToSpeechRequest request) {
		super("v1/text-to-speech/" + voiceId, File.class);
		this.request = request;
	}

	@Override
	public Object getPayload() {
		return request;
	}
}
