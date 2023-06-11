package net.andrewcpu.elevenlabs.model.voice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.tuning.FineTuning;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Voice extends ElevenModel {
	public static List<Voice> getVoices() {
		return ElevenLabs.getVoices();
	}

	public static Voice getVoice(String voiceId) {
		return ElevenLabs.getVoice(voiceId);
	}

	public static Voice getVoice(String voiceId, boolean withSettings) {
		return ElevenLabs.getVoice(voiceId, withSettings);
	}

	@JsonProperty("voice_id")
	private String voiceId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("samples")
	private List<Sample> samples;

	@JsonProperty("category")
	private String category;

	@JsonProperty("fine_tuning")
	private FineTuning fineTuning;

	@JsonProperty("labels")
	private Map<String, String> labels;

	@JsonProperty("description")
	private String description;

	@JsonProperty("preview_url")
	private String previewUrl;

	@JsonProperty("available_for_tiers")
	private List<String> availableForTiers;

	@JsonProperty("settings")
	private VoiceSettings settings;

	@JsonProperty("sharing")
	private Sharing sharing;

	@JsonIgnore
	public String getVoiceId() {
		return voiceId;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@JsonIgnore
	public List<Sample> getSamples() {
		return samples.stream().peek(s -> s.voice = this).collect(Collectors.toList());
	}

	@JsonIgnore
	public String getCategory() {
		return category;
	}

	@JsonIgnore
	public FineTuning getFineTuning() {
		return fineTuning;
	}

	@JsonIgnore
	public Map<String, String> getLabels() {
		return labels;
	}

	@JsonIgnore
	public String getDescription() {
		return description;
	}

	@JsonIgnore
	public String getPreviewUrl() {
		return previewUrl;
	}

	@JsonIgnore
	public List<String> getAvailableForTiers() {
		return availableForTiers;
	}

	@JsonIgnore
	public VoiceSettings getSettings() {
		return settings;
	}

	@JsonIgnore
	public Sharing getSharing() {
		return sharing;
	}

	/**
	 * Warning! This will delete the voice.
	 */
	public String delete() {
		return ElevenLabs.deleteVoice(voiceId);
	}
	public VoiceSettings fetchSettings() {
		this.settings = ElevenLabs.getVoiceSettings(voiceId);
		return settings;
	}

	public VoiceSettings updateVoiceSettings(VoiceSettings voiceSettings) {
		ElevenLabs.editVoiceSettings(voiceId, voiceSettings);
		this.settings = voiceSettings;
		return settings;
	}

	public Voice refresh() {
		Voice refreshedData = Voice.getVoice(voiceId, true);
		this.name = refreshedData.name;
		this.settings = refreshedData.settings;
		this.voiceId = refreshedData.voiceId;
		this.labels = refreshedData.labels;
		this.description = refreshedData.description;
		this.samples = refreshedData.samples;
		this.fineTuning = refreshedData.fineTuning;
		this.availableForTiers = refreshedData.availableForTiers;
		this.sharing = refreshedData.sharing;
		this.previewUrl = refreshedData.previewUrl;
		this.category = refreshedData.category;
		return this;
	}

	public File generate(String text, String model) {
		return ElevenLabs.generateTextToSpeech(voiceId, text, model, settings);
	}

	public File generate(String text, String model, VoiceSettings settings) {
		return ElevenLabs.generateTextToSpeech(voiceId, text, model, settings);
	}

	public File generate(String text, VoiceSettings settings)  {
		return ElevenLabs.generateTextToSpeech(voiceId, text, "eleven_monolingual_v1", settings);
	}

	public File generate(String text) {
		return ElevenLabs.generateTextToSpeech(voiceId, text, "eleven_monolingual_v1", settings);
	}

	public InputStream generateStream(String text, String model) {
		return ElevenLabs.generateTextToSpeechStreamed(voiceId, text, model, settings);
	}

	public InputStream generateStream(String text, String model, VoiceSettings settings) {
		return ElevenLabs.generateTextToSpeechStreamed(voiceId, text, model, settings);
	}

	public InputStream generateStream(String text, VoiceSettings settings)  {
		return ElevenLabs.generateTextToSpeechStreamed(voiceId, text, "eleven_monolingual_v1", settings);
	}

	public InputStream generateStream(String text) {
		return ElevenLabs.generateTextToSpeechStreamed(voiceId, text, "eleven_monolingual_v1", settings);
	}


	@JsonIgnore
	@Override
	public String toString() {
		return "Voice{" +
				"voiceId='" + voiceId + '\'' +
				", name='" + name + '\'' +
				", samples=" + samples +
				", category='" + category + '\'' +
				", fineTuning=" + fineTuning +
				", labels=" + labels +
				", description='" + description + '\'' +
				", previewUrl='" + previewUrl + '\'' +
				", availableForTiers=" + availableForTiers +
				", settings=" + settings +
				", sharing=" + sharing +
				'}';
	}
}
