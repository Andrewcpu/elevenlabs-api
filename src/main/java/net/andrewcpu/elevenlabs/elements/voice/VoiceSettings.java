package net.andrewcpu.elevenlabs.elements.voice;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONObject;

import java.io.IOException;

@SuppressWarnings("unchecked")
public class VoiceSettings {
	private double stability;
	private double similarityBoost;

	public static VoiceSettings fromJSON(JSONObject object){
		return new VoiceSettings((double)object.get("stability"), (double)object.get("similarity"));
	}
	public static VoiceSettings getDefaultVoiceSettings() throws IOException, ElevenLabsValidationException, ElevenLabsAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getDefaultVoiceSettings();
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

	@Override
	public String toString() {
		return "VoiceSettings{" +
				"stability=" + stability +
				", similarityBoost=" + similarityBoost +
				'}';
	}
}
