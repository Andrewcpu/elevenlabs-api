package net.andrewcpu.elevenlabs.elements.voice;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.elements.VoiceBuilder;
import net.andrewcpu.elevenlabs.exceptions.ElevenAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Voice {
	private final String voiceId;
	private final String name;
	private final List<Sample> samples;
	private final String category;
	private final Map<String, String> labels;
	private final String previewUrl;
	private final List<String> availableForTiers;
	private VoiceSettings voiceSettings;

	public static Voice fromJSON(JSONObject object) {
		String voiceId = (String) object.get("voice_id");
		String name = (String) object.get("name");
		JSONArray samplesJson = (JSONArray) object.get("samples");
		List<Sample> samples = new ArrayList<>();
		for (Object sampleObj : samplesJson) {
			JSONObject sampleJson = (JSONObject) sampleObj;
			samples.add(Sample.fromJSON(sampleJson));
		}
		String category = (String) object.get("category");
		JSONObject labelsJson = (JSONObject) object.get("labels");
		Map<String, String> labels = new HashMap<>();
		for (Object key : labelsJson.keySet()) {
			String labelName = (String) key;
			String labelValue = (String) labelsJson.get(labelName);
			labels.put(labelName, labelValue);
		}
		String previewUrl = (String) object.get("preview_url");
		JSONArray availableForTiersJson = (JSONArray) object.get("available_for_tiers");
		List<String> availableForTiers = new ArrayList<>();
		for (Object tier : availableForTiersJson) {
			availableForTiers.add((String) tier);
		}
		double stab = 0;
		double sim = 0;
		if(object.containsKey("settings") && object.get("settings") != null){
			JSONObject settingsJson = (JSONObject) object.get("settings");
			VoiceSettings settings = new VoiceSettings(((Long) settingsJson.get("stability")).doubleValue(),
					((Long) settingsJson.get("similarity_boost")).doubleValue());
			stab = settings.getStability();
			sim = settings.getSimilarityBoost();
		}

		Voice voice = new Voice(voiceId, name, samples, category, labels, previewUrl, availableForTiers, stab, sim);
		voice.getSamples().forEach(s -> s.setVoice(voice));
		return voice;
	}



	public static List<Voice> getVoices() throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getVoices();
	}

	public static Voice get(String voiceId) throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getVoice(voiceId);
	}

	public static Voice get(String voiceId, boolean withSettings) throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getVoice(voiceId, withSettings);
	}


	public Voice(String voiceId, String name, List<Sample> samples, String category, Map<String, String> labels, String previewUrl, List<String> availableForTiers, double stability, double similarityBoost) {
		this.voiceId = voiceId;
		this.name = name;
		this.samples = samples;
		this.category = category;
		this.labels = labels;
		this.previewUrl = previewUrl;
		this.availableForTiers = availableForTiers;
		this.voiceSettings = new VoiceSettings(stability, similarityBoost);
	}

	public String getVoiceId() {
		return voiceId;
	}

	public String getName() {
		return name;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public String getCategory() {
		return category;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public List<String> getAvailableForTiers() {
		return availableForTiers;
	}

	public VoiceSettings getVoiceSettings() {
		return voiceSettings;
	}

	public String delete() throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().deleteVoice(getVoiceId());
	}

	public void fetchSettings() throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		this.voiceSettings = ElevenLabsAPI.getInstance().getVoiceSettings(getVoiceId());
	}

	public VoiceBuilder builder() {
		return VoiceBuilder.fromVoice(this);
	}

	public String updateVoiceSettings(VoiceSettings settings) throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		String response = ElevenLabsAPI.getInstance().editVoice(this, settings);
		if(response != null){
			this.voiceSettings = settings;
			return response;
		}
		return null;
	}

	public File generate(String text, VoiceSettings voiceSettings, File output) throws ElevenLabsValidationException, IOException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getTextToSpeech(text, this, voiceSettings,output);
	}

	public File generate(String text, File output) throws ElevenLabsValidationException, IOException, ElevenAPINotInitiatedException {
		return generate(text, voiceSettings, output);
	}

	@Override
	public String toString() {
		return "Voice{" +
				"voiceId='" + voiceId + '\'' +
				", name='" + name + '\'' +
				", samples=" + samples +
				", category='" + category + '\'' +
				", labels=" + labels +
				", previewUrl='" + previewUrl + '\'' +
				", availableForTiers=" + availableForTiers +
				", voiceSettings=" + voiceSettings +
				'}';
	}
}
