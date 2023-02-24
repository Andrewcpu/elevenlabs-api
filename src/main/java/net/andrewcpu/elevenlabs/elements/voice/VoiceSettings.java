package net.andrewcpu.elevenlabs.elements.voice;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONObject;

import java.io.IOException;

public class VoiceSettings {
	private double stability;
	private double similarityBoost;

	public static VoiceSettings fromJSON(JSONObject object){
		return new VoiceSettings((double)object.get("stability"), (double)object.get("similarity"));
	}

	public VoiceSettings(double stability, double similarityBoost) {
		this.stability = stability;
		this.similarityBoost = similarityBoost;
	}

	public double getStability() {
		return stability;
	}

	public void setStability(double stability) {
		this.stability = stability;
	}

	public double getSimilarityBoost() {
		return similarityBoost;
	}

	public void setSimilarityBoost(double similarityBoost) {
		this.similarityBoost = similarityBoost;
	}

	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put("stability", stability);
		object.put("similarity_boost", similarityBoost);
		return object;
	}

	public static VoiceSettings getDefaultVoiceSettings() throws IOException, ElevenLabsValidationException {
		return ElevenLabsAPI.getInstance().getDefaultVoiceSettings();
	}

	@Override
	public String toString() {
		return "VoiceSettings{" +
				"stability=" + stability +
				", similarityBoost=" + similarityBoost +
				'}';
	}
}
