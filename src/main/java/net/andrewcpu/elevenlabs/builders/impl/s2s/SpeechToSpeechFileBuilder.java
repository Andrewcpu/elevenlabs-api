package net.andrewcpu.elevenlabs.builders.impl.s2s;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.abstracts.AbstractSpeechGenerationBuilder;

import java.io.File;

public class SpeechToSpeechFileBuilder extends AbstractSpeechGenerationBuilder<SpeechToSpeechFileBuilder, File> {
	private File inputFile;

	public File getInputFile() {
		return inputFile;
	}

	public SpeechToSpeechFileBuilder setInputFile(File inputFile) {
		this.inputFile = inputFile;
		return this;
	}

	@Override
	public SpeechToSpeechFileBuilder self() {
		return this;
	}

	@Override
	public File build() {
		return ElevenLabs
				.getSpeechToSpeechAPI()
				.generateSpeechToSpeech(getVoiceId(), getVoiceSettings(),getModelId(),getInputFile(),getLatencyOptimization());
	}

}
