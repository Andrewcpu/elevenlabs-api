package net.andrewcpu.elevenlabs.elements.voice;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.api.VoiceAPI;
import net.andrewcpu.elevenlabs.elements.VoiceBuilder;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import net.andrewcpu.elevenlabs.util.StreamedResponseCallback;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.util.*;

public class Voice {
	private final String voiceId;
	private final String name;
	private final List<Sample> samples;
	private final String category;
	private final Map<String, String> labels;
	private final String previewUrl;
	private final List<String> availableForTiers;
	private VoiceSettings voiceSettings;
	private boolean hasSettings;


	public static Voice fromJSON(JSONObject object) {
		String voiceId = (String) object.get("voice_id");
		String name = (String) object.get("name");
		List<Sample> samples = new ArrayList<>();
		if(object.containsKey("samples") && object.get("samples") != null){
			JSONArray samplesJson = (JSONArray) object.get("samples");
			for (Object sampleObj : samplesJson) {
				JSONObject sampleJson = (JSONObject) sampleObj;
				samples.add(Sample.fromJSON(sampleJson));
			}
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
		double stab = -1;
		double sim = -1;
		if(object.containsKey("settings") && object.get("settings") != null){
			JSONObject settingsJson = (JSONObject) object.get("settings");
			VoiceSettings settings = new VoiceSettings(((Double) settingsJson.get("stability")),
					((Double) settingsJson.get("similarity_boost")));
			stab = settings.getStability();
			sim = settings.getSimilarityBoost();
		}

		Voice voice = new Voice(voiceId, name, samples, category, labels, previewUrl, availableForTiers, stab, sim);
		voice.hasSettings = stab != -1;
		voice.getSamples().forEach(s -> s.setVoice(voice));
		return voice;
	}



	public static List<Voice> getVoices() throws ElevenLabsException {
		return VoiceAPI.getVoices();
	}

	public static Voice get(String voiceId) throws ElevenLabsException {
		Voice voice = VoiceAPI.getVoice(voiceId);
		voice.hasSettings = true;
		return voice;
	}

	public static Voice get(String voiceId, boolean withSettings) throws ElevenLabsException {
		Voice voice = VoiceAPI.getVoice(voiceId, withSettings);
		voice.hasSettings = withSettings;
		return voice;
	}


	private Voice(String voiceId, String name, List<Sample> samples, String category, Map<String, String> labels, String previewUrl, List<String> availableForTiers, double stability, double similarityBoost) {
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

	public boolean delete() throws ElevenLabsException {
		return VoiceAPI.deleteVoice(getVoiceId());
	}

	public void fetchSettings() throws ElevenLabsException {
		this.voiceSettings = VoiceAPI.getVoiceSettings(getVoiceId());
		hasSettings = true;
	}

	public VoiceBuilder editor() {
		return VoiceBuilder.fromVoice(this);
	}

	public void updateVoiceSettings(VoiceSettings settings) throws ElevenLabsException {
		JSONObject response = VoiceAPI.editVoice(this, settings);
		if(response != null){
			this.voiceSettings = settings;
			hasSettings = true;
			return;
		}
	}

	public File generate(String text, VoiceSettings voiceSettings, File output) throws ElevenLabsException {
		return VoiceAPI.getTextToSpeech(text, this, voiceSettings,output);
	}

	public File generate(String text, File output) throws ElevenLabsException {
		if(!hasSettings){
			throw new ElevenLabsValidationException("Cannot use default voice settings for " + voiceId + " because this object does not have VoiceSettings");
		}
		return generate(text, voiceSettings, output);
	}

	public InputStream generateStream(String text, VoiceSettings voiceSettings, StreamedResponseCallback streamedResponseCallback, File file) throws ElevenLabsException {
		return VoiceAPI.getTextToSpeechStreamed(text, this, voiceSettings, streamedResponseCallback, file);
	}

	public InputStream generateStream(String text, StreamedResponseCallback callback, File file) throws ElevenLabsException {
		return generateStream(text, voiceSettings, callback, file);
	}

	public String getLabel(String label) {
		return labels.get(label);
	}

	public boolean hasLabel(String label){
		return labels.containsKey(label);
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
