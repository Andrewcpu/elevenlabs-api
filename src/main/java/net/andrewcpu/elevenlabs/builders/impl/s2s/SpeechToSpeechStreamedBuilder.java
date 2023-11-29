package net.andrewcpu.elevenlabs.builders.impl.s2s;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.abstracts.AbstractSpeechGenerationBuilder;

import java.io.File;
import java.io.InputStream;

public class SpeechToSpeechStreamedBuilder extends AbstractSpeechGenerationBuilder<SpeechToSpeechStreamedBuilder, InputStream> {
	private File inputFile;

	public File getInputFile() {
		return inputFile;
	}

	public SpeechToSpeechStreamedBuilder setInputFile(File inputFile) {
		this.inputFile = inputFile;
		return this;
	}

	@Override
	public SpeechToSpeechStreamedBuilder self() {
		return this;
	}

	@Override
	public InputStream build() {
		return ElevenLabs
				.getSpeechToSpeechAPI()
				.generateSpeechToSpeechStream(getVoiceId(), getVoiceSettings(),getModelId(),getInputFile(),getLatencyOptimization());
	}
}
