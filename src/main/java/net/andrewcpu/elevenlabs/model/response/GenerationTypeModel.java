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

	@JsonProperty("can_use_style")
	private boolean canUseStyle;

	@JsonProperty("can_use_speaker_boost")
	private boolean canUseSpeakerBoost;

	@JsonProperty("serves_pro_voices")
	private boolean servesProVoices;

	@JsonProperty("token_cost_factor")
	private int tokenCostFactor;

	@JsonProperty("description")
	private String description;

	@JsonProperty("requires_alpha_access")
	private boolean requiresAlphaAccess;

	@JsonProperty("max_characters_request_free_user")
	private int maxCharactersRequestFreeUser;
	@JsonProperty("max_characters_request_subscribed_user")
	private int maxCharactersRequestSubscribedUser;

	@JsonProperty("languages")
	private List<Language> languages;

	public GenerationTypeModel(String modelId, String name, boolean canBeFinetuned, boolean canDoTextToSpeech, boolean canDoVoiceConversion, boolean canUseStyle, boolean canUseSpeakerBoost, boolean servesProVoices, int tokenCostFactor, String description, boolean requiresAlphaAccess, int maxCharactersRequestFreeUser, int maxCharactersRequestSubscribedUser, List<Language> languages) {
		this.modelId = modelId;
		this.name = name;
		this.canBeFinetuned = canBeFinetuned;
		this.canDoTextToSpeech = canDoTextToSpeech;
		this.canDoVoiceConversion = canDoVoiceConversion;
		this.canUseStyle = canUseStyle;
		this.canUseSpeakerBoost = canUseSpeakerBoost;
		this.servesProVoices = servesProVoices;
		this.tokenCostFactor = tokenCostFactor;
		this.description = description;
		this.requiresAlphaAccess = requiresAlphaAccess;
		this.maxCharactersRequestFreeUser = maxCharactersRequestFreeUser;
		this.maxCharactersRequestSubscribedUser = maxCharactersRequestSubscribedUser;
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
	public boolean isCanUseStyle() {
		return canUseStyle;
	}

	@JsonIgnore
	public boolean isCanUseSpeakerBoost() {
		return canUseSpeakerBoost;
	}

	@JsonIgnore
	public boolean isServesProVoices() {
		return servesProVoices;
	}

	@JsonIgnore
	public boolean isRequiresAlphaAccess() {
		return requiresAlphaAccess;
	}

	@JsonIgnore
	public int getMaxCharactersRequestFreeUser() {
		return maxCharactersRequestFreeUser;
	}

	@JsonIgnore
	public int getMaxCharactersRequestSubscribedUser() {
		return maxCharactersRequestSubscribedUser;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "GenerationTypeModel{" +
				"modelId='" + modelId + '\'' +
				", name='" + name + '\'' +
				", canBeFinetuned=" + canBeFinetuned +
				", canDoTextToSpeech=" + canDoTextToSpeech +
				", canDoVoiceConversion=" + canDoVoiceConversion +
				", canUseStyle=" + canUseStyle +
				", canUseSpeakerBoost=" + canUseSpeakerBoost +
				", servesProVoices=" + servesProVoices +
				", tokenCostFactor=" + tokenCostFactor +
				", description='" + description + '\'' +
				", requiresAlphaAccess=" + requiresAlphaAccess +
				", maxCharactersRequestFreeUser=" + maxCharactersRequestFreeUser +
				", maxCharactersRequestSubscribedUser=" + maxCharactersRequestSubscribedUser +
				", languages=" + languages +
				'}';
	}
}
