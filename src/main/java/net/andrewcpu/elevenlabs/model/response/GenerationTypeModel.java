package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.Language;

import java.util.List;

public class GenerationTypeModel extends ElevenModel {
	@JsonProperty("model_id")
	private String modelId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("can_be_finetuned")
	private boolean canBeFinetuned;

	@JsonProperty("can_do_text_to_speech")
	private boolean canDoTextToSpeech;

	@JsonProperty("can_do_voice_conversion")
	private boolean canDoVoiceConversion;

	@JsonProperty("token_cost_factor")
	private int tokenCostFactor;

	@JsonProperty("description")
	private String description;

	@JsonProperty("languages")
	private List<Language> languages;

	public GenerationTypeModel(String modelId, String name, boolean canBeFinetuned, boolean canDoTextToSpeech, boolean canDoVoiceConversion, int tokenCostFactor, String description, List<Language> languages) {
		this.modelId = modelId;
		this.name = name;
		this.canBeFinetuned = canBeFinetuned;
		this.canDoTextToSpeech = canDoTextToSpeech;
		this.canDoVoiceConversion = canDoVoiceConversion;
		this.tokenCostFactor = tokenCostFactor;
		this.description = description;
		this.languages = languages;
	}

	public GenerationTypeModel() {
	}

	@JsonIgnore
	public String getModelId() {
		return modelId;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@JsonIgnore
	public boolean isCanBeFinetuned() {
		return canBeFinetuned;
	}

	@JsonIgnore
	public boolean isCanDoTextToSpeech() {
		return canDoTextToSpeech;
	}

	@JsonIgnore
	public boolean isCanDoVoiceConversion() {
		return canDoVoiceConversion;
	}

	@JsonIgnore
	public int getTokenCostFactor() {
		return tokenCostFactor;
	}

	@JsonIgnore
	public String getDescription() {
		return description;
	}

	@JsonIgnore
	public List<Language> getLanguages() {
		return languages;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "ModelResponse{" +
				"modelId='" + modelId + '\'' +
				", name='" + name + '\'' +
				", canBeFinetuned=" + canBeFinetuned +
				", canDoTextToSpeech=" + canDoTextToSpeech +
				", canDoVoiceConversion=" + canDoVoiceConversion +
				", tokenCostFactor=" + tokenCostFactor +
				", description='" + description + '\'' +
				", languages=" + languages +
				'}';
	}
}
