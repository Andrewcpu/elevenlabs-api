package net.andrewcpu.elevenlabs.model.voice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.tuning.FineTuning;

import java.util.List;
import java.util.Map;

public class Voice extends ElevenModel {
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
		return samples;
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
