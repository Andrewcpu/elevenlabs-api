package net.andrewcpu.elevenlabs.builders;

public class SpeechGenerationBuilder {
	public static SpeechToSpeechBuilder speechToSpeech() {
		return new SpeechToSpeechBuilder();
	}

	public static TextToSpeechBuilder textToSpeech() {
		return new TextToSpeechBuilder();
	}
}
