package net.andrewcpu.elevenlabs.model.voice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class VoiceSettings extends ElevenModel {
	public static VoiceSettings getDefaultVoiceSettings() {
		return ElevenLabs.getDefaultVoiceSettings();
	}
	@JsonProperty("stability")
	private double stability;

	@JsonProperty("similarity_boost")
	private double similarityBoost;

	@JsonProperty("style")
	private double style;

	@JsonProperty("use_speaker_boost")
	private boolean useSpeakerBoost;

	public VoiceSettings(double stability, double similarityBoost, double style, boolean useSpeakerBoost) {
		this.stability = stability;
		this.similarityBoost = similarityBoost;
		this.style = style;
		this.useSpeakerBoost = useSpeakerBoost;
	}

	public VoiceSettings(double stability, double similarityBoost) {
		this.stability = stability;
		this.similarityBoost = similarityBoost;
		this.style = 0;
		this.useSpeakerBoost = true;
	}

	public VoiceSettings() {
	}

	@JsonIgnore
	public double getStability() {
		return stability;
	}

	@JsonIgnore
	public double getSimilarityBoost() {
		return similarityBoost;
	}

	@JsonIgnore
	public double getStyle() {
		return style;
	}

	@JsonIgnore
	public boolean isUseSpeakerBoost() {
		return useSpeakerBoost;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "VoiceSettings{" +
				"stability=" + stability +
				", similarityBoost=" + similarityBoost +
				", style=" + style +
				", useSpeakerBoost=" + useSpeakerBoost +
				'}';
	}
}
