package net.andrewcpu.elevenlabs.builders;


import net.andrewcpu.elevenlabs.builders.impl.tts.TextToSpeechFileBuilder;
import net.andrewcpu.elevenlabs.builders.impl.tts.TextToSpeechStreamedBuilder;

public class TextToSpeechBuilder  {
	public TextToSpeechStreamedBuilder streamed() {
		return new TextToSpeechStreamedBuilder();
	}

	public TextToSpeechFileBuilder file() {
		return new TextToSpeechFileBuilder();
	}
}
