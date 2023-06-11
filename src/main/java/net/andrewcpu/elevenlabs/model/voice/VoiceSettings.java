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

	public VoiceSettings(double stability, double similarityBoost) {
		this.stability = stability;
		this.similarityBoost = similarityBoost;
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
	@Override
	public String toString() {
		return "VoiceSettings{" +
				"stability=" + stability +
				", similarityBoost=" + similarityBoost +
				'}';
	}
}
