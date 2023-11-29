package net.andrewcpu.elevenlabs.builders;

import net.andrewcpu.elevenlabs.builders.impl.s2s.SpeechToSpeechFileBuilder;
import net.andrewcpu.elevenlabs.builders.impl.s2s.SpeechToSpeechStreamedBuilder;

public class SpeechToSpeechBuilder  {

	public SpeechToSpeechStreamedBuilder streamed() {
		return new SpeechToSpeechStreamedBuilder();
	}

	public SpeechToSpeechFileBuilder file() {
		return new SpeechToSpeechFileBuilder();
	}
}
