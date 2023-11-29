package net.andrewcpu.elevenlabs.builders.impl.tts;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.abstracts.AbstractSpeechGenerationBuilder;

import java.io.File;

public class TextToSpeechFileBuilder extends AbstractSpeechGenerationBuilder<TextToSpeechFileBuilder, File> {
	private String text;

	public String getText() {
		return text;
	}

	public TextToSpeechFileBuilder setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public TextToSpeechFileBuilder self() {
		return this;
	}

	@Override
	public File build() {
		return ElevenLabs
				.getTextToSpeechAPI()
				.generateTextToSpeech(getVoiceId(), getText(),getModelId(), getGeneratedAudioOutputFormat(),getLatencyOptimization(), getVoiceSettings());
	}
}
