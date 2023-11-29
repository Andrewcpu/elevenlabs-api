package net.andrewcpu.elevenlabs.builders.abstracts;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.builders.SpeechToSpeechBuilder;
import net.andrewcpu.elevenlabs.builders.TextToSpeechBuilder;
import net.andrewcpu.elevenlabs.enums.ElevenLabsVoiceModel;
import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;

public abstract class AbstractSpeechGenerationBuilder<T, F> {
	private String voiceId;
	private VoiceSettings voiceSettings;
	private String modelId = ElevenLabs.getDefaultModel();
	private StreamLatencyOptimization latencyOptimization = StreamLatencyOptimization.getDefault();
	private GeneratedAudioOutputFormat generatedAudioOutputFormat = GeneratedAudioOutputFormat.getDefault();
	public abstract T self();

	public abstract F build();


	public GeneratedAudioOutputFormat getGeneratedAudioOutputFormat() {
		return generatedAudioOutputFormat;
	}

	public T setGeneratedAudioOutputFormat(GeneratedAudioOutputFormat generatedAudioOutputFormat) {
		this.generatedAudioOutputFormat = generatedAudioOutputFormat;
		return self();
	}

	public String getVoiceId() {
		return voiceId;
	}

	public T setVoiceId(String voiceId) {
		this.voiceId = voiceId;
		return self();
	}

	public VoiceSettings getVoiceSettings() {
		return voiceSettings;
	}

	public T setVoiceSettings(VoiceSettings voiceSettings) {
		this.voiceSettings = voiceSettings;
		return self();
	}

	public String getModelId() {
		return modelId;
	}

	public T setModelId(String modelId) {
		this.modelId = modelId;
		return self();
	}

	public StreamLatencyOptimization getLatencyOptimization() {
		return latencyOptimization;
	}

	public T setLatencyOptimization(StreamLatencyOptimization latencyOptimization) {
		this.latencyOptimization = latencyOptimization;
		return self();
	}

	public T setVoice(Voice voice) {
		this.voiceId = voice.getVoiceId();
		if(voice.getSettings() == null) voice.fetchSettings();
		this.voiceSettings = voice.getSettings();
		return self();
	}

	public T setModel(ElevenLabsVoiceModel voiceModel) {
		this.modelId = voiceModel.getModelId();
		return self();
	}
}
