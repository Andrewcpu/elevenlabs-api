package net.andrewcpu.elevenlabs.builders.impl.tts;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.abstracts.AbstractSpeechGenerationBuilder;

import java.io.InputStream;

public class TextToSpeechStreamedBuilder extends AbstractSpeechGenerationBuilder<TextToSpeechStreamedBuilder, InputStream> {
	private String text;

	public String getText() {
		return text;
	}

	public TextToSpeechStreamedBuilder setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public TextToSpeechStreamedBuilder self() {
		return this;
	}

	@Override
	public InputStream build() {
		return ElevenLabs
				.getTextToSpeechAPI()
				.generateTextToSpeechStreamed(getVoiceId(), getText(),getModelId(), getGeneratedAudioOutputFormat(),getLatencyOptimization(), getVoiceSettings());
	}
}
