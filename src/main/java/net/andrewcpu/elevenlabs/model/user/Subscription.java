package net.andrewcpu.elevenlabs.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Subscription extends ElevenModel {
	@JsonIgnore
	public static Subscription get() {
		return ElevenLabs.getSubscription();
	}

	@JsonProperty("tier")
	private String tier;

	@JsonProperty("character_count")
	private int characterCount;

	@JsonProperty("character_limit")
	private int characterLimit;

	@JsonProperty("can_extend_character_limit")
	private boolean canExtendCharacterLimit;

	@JsonProperty("allowed_to_extend_character_limit")
	private boolean allowedToExtendCharacterLimit;

	@JsonProperty("next_character_count_reset_unix")
	private long nextCharacterCountResetUnix;

	@JsonProperty("voice_limit")
	private int voiceLimit;

	@JsonProperty("professional_voice_limit")
	private int professionalVoiceLimit;

	@JsonProperty("can_extend_voice_limit")
	private boolean canExtendVoiceLimit;

	@JsonProperty("can_use_instant_voice_cloning")
	private boolean canUseInstantVoiceCloning;

	@JsonProperty("can_use_professional_voice_cloning")
	private boolean canUseProfessionalVoiceCloning;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("status")
	private String status;

	public Subscription(String tier, int characterCount, int characterLimit, boolean canExtendCharacterLimit, boolean allowedToExtendCharacterLimit, long nextCharacterCountResetUnix, int voiceLimit, int professionalVoiceLimit, boolean canExtendVoiceLimit, boolean canUseInstantVoiceCloning, boolean canUseProfessionalVoiceCloning, String currency, String status) {
		this.tier = tier;
		this.characterCount = characterCount;
		this.characterLimit = characterLimit;
		this.canExtendCharacterLimit = canExtendCharacterLimit;
		this.allowedToExtendCharacterLimit = allowedToExtendCharacterLimit;
		this.nextCharacterCountResetUnix = nextCharacterCountResetUnix;
		this.voiceLimit = voiceLimit;
		this.professionalVoiceLimit = professionalVoiceLimit;
		this.canExtendVoiceLimit = canExtendVoiceLimit;
		this.canUseInstantVoiceCloning = canUseInstantVoiceCloning;
		this.canUseProfessionalVoiceCloning = canUseProfessionalVoiceCloning;
		this.currency = currency;
		this.status = status;
	}

	public Subscription() {
	}

	@JsonIgnore
	public String getTier() {
		return tier;
	}

	@JsonIgnore
	public int getCharacterCount() {
		return characterCount;
	}

	@JsonIgnore
	public int getCharacterLimit() {
		return characterLimit;
	}

	@JsonIgnore
	public boolean isCanExtendCharacterLimit() {
		return canExtendCharacterLimit;
	}

	@JsonIgnore
	public boolean isAllowedToExtendCharacterLimit() {
		return allowedToExtendCharacterLimit;
	}

	@JsonIgnore
	public long getNextCharacterCountResetUnix() {
		return nextCharacterCountResetUnix;
	}

	@JsonIgnore
	public int getVoiceLimit() {
		return voiceLimit;
	}

	@JsonIgnore
	public int getProfessionalVoiceLimit() {
		return professionalVoiceLimit;
	}

	@JsonIgnore
	public boolean isCanExtendVoiceLimit() {
		return canExtendVoiceLimit;
	}

	@JsonIgnore
	public boolean isCanUseInstantVoiceCloning() {
		return canUseInstantVoiceCloning;
	}

	@JsonIgnore
	public boolean isCanUseProfessionalVoiceCloning() {
		return canUseProfessionalVoiceCloning;
	}

	@JsonIgnore
	public String getCurrency() {
		return currency;
	}

	@JsonIgnore
	public String getStatus() {
		return status;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "Subscription{" +
				"tier='" + tier + '\'' +
				", characterCount=" + characterCount +
				", characterLimit=" + characterLimit +
				", canExtendCharacterLimit=" + canExtendCharacterLimit +
				", allowedToExtendCharacterLimit=" + allowedToExtendCharacterLimit +
				", nextCharacterCountResetUnix=" + nextCharacterCountResetUnix +
				", voiceLimit=" + voiceLimit +
				", professionalVoiceLimit=" + professionalVoiceLimit +
				", canExtendVoiceLimit=" + canExtendVoiceLimit +
				", canUseInstantVoiceCloning=" + canUseInstantVoiceCloning +
				", canUseProfessionalVoiceCloning=" + canUseProfessionalVoiceCloning +
				", currency='" + currency + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
