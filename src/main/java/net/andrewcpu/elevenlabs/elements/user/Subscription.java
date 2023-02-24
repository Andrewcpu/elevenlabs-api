package net.andrewcpu.elevenlabs.elements.user;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.enums.Status;
import net.andrewcpu.elevenlabs.exceptions.ElevenAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Subscription {
	private final String tier;
	private final int characterCount;
	private final int characterLimit;
	private final boolean canExtendCharacterLimit;
	private final boolean allowedToExtendCharacterLimit;
	private final long nextCharacterCountResetUnix;
	private final int voiceLimit;
	private final boolean canExtendVoiceLimit;
	private final boolean canUseInstantVoiceCloning;
	private final List<AvailableModel> availableModels;
	private final Status status;
	private final NextInvoice nextInvoice;

	public static Subscription getSubscription() throws ElevenLabsValidationException, IOException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getSubscription();
	}

	public Subscription(String tier, int characterCount, int characterLimit, boolean canExtendCharacterLimit, boolean allowedToExtendCharacterLimit, long nextCharacterCountResetUnix, int voiceLimit, boolean canExtendVoiceLimit, boolean canUseInstantVoiceCloning, List<AvailableModel> availableModels, String status, NextInvoice nextInvoice) {
		this.tier = tier;
		this.characterCount = characterCount;
		this.characterLimit = characterLimit;
		this.canExtendCharacterLimit = canExtendCharacterLimit;
		this.allowedToExtendCharacterLimit = allowedToExtendCharacterLimit;
		this.nextCharacterCountResetUnix = nextCharacterCountResetUnix;
		this.voiceLimit = voiceLimit;
		this.canExtendVoiceLimit = canExtendVoiceLimit;
		this.canUseInstantVoiceCloning = canUseInstantVoiceCloning;
		this.availableModels = availableModels;
		this.status = Status.valueOf(status.toUpperCase());
		this.nextInvoice = nextInvoice;
	}

	public String getTier() {
		return tier;
	}

	public int getCharacterCount() {
		return characterCount;
	}

	public int getCharacterLimit() {
		return characterLimit;
	}

	public boolean isCanExtendCharacterLimit() {
		return canExtendCharacterLimit;
	}

	public boolean isAllowedToExtendCharacterLimit() {
		return allowedToExtendCharacterLimit;
	}

	public long getNextCharacterCountResetUnix() {
		return nextCharacterCountResetUnix;
	}

	public int getVoiceLimit() {
		return voiceLimit;
	}

	public boolean isCanExtendVoiceLimit() {
		return canExtendVoiceLimit;
	}

	public boolean isCanUseInstantVoiceCloning() {
		return canUseInstantVoiceCloning;
	}

	public List<AvailableModel> getAvailableModels() {
		return availableModels;
	}

	public Status getStatus() {
		return status;
	}

	public NextInvoice getNextInvoice() {
		return nextInvoice;
	}

	public static Subscription fromJSON(JSONObject object) {
		String tier = (String) object.get("tier");
		int characterCount = ((Long) object.get("character_count")).intValue();
		int characterLimit = ((Long) object.get("character_limit")).intValue();
		boolean canExtendCharacterLimit = (Boolean) object.get("can_extend_character_limit");
		boolean allowedToExtendCharacterLimit = (Boolean) object.get("allowed_to_extend_character_limit");
		long nextCharacterCountResetUnix = (Long) object.get("next_character_count_reset_unix");
		int voiceLimit = ((Long) object.get("voice_limit")).intValue();
		boolean canExtendVoiceLimit = (Boolean) object.get("can_extend_voice_limit");
		boolean canUseInstantVoiceCloning = (Boolean) object.get("can_use_instant_voice_cloning");
		List<AvailableModel> availableModels = new ArrayList<>();
		JSONArray availableModelsJson = (JSONArray) object.get("available_models");
		for (Object model : availableModelsJson) {
			JSONObject modelJson = (JSONObject) model;
			String modelId = (String) modelJson.get("model_id");
			String displayName = (String) modelJson.get("display_name");
			List<SupportedLanguage> supportedLanguages = new ArrayList<>();
			JSONArray supportedLanguagesJson = (JSONArray) modelJson.get("supported_languages");
			for (Object language : supportedLanguagesJson) {
				JSONObject languageJson = (JSONObject) language;
				String isoCode = (String) languageJson.get("iso_code");
				String languageDisplayName = (String) languageJson.get("display_name");
				supportedLanguages.add(new SupportedLanguage(isoCode, languageDisplayName));
			}
			availableModels.add(new AvailableModel(modelId, displayName, supportedLanguages));
		}
		String status = (String) object.get("status");
		NextInvoice invoice = null;
		if(object.containsKey("next_invoice")){
			JSONObject nextInvoiceJson = (JSONObject) object.get("next_invoice");
			invoice = new NextInvoice(
					((Long) nextInvoiceJson.get("amount_due_cents")).intValue(),
					(Long) nextInvoiceJson.get("next_payment_attempt_unix")
			);

		}
		return new Subscription(tier, characterCount, characterLimit, canExtendCharacterLimit, allowedToExtendCharacterLimit, nextCharacterCountResetUnix, voiceLimit, canExtendVoiceLimit, canUseInstantVoiceCloning, availableModels, status, invoice);
	}

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
				", canExtendVoiceLimit=" + canExtendVoiceLimit +
				", canUseInstantVoiceCloning=" + canUseInstantVoiceCloning +
				", availableModels=" + availableModels +
				", status='" + status + '\'' +
				", nextInvoice=" + nextInvoice +
				'}';
	}

	public record AvailableModel(String modelId, String displayName, List<SupportedLanguage> supportedLanguages) {


		@Override
			public String toString() {
				return "AvailableModel{" +
						"modelId='" + modelId + '\'' +
						", displayName='" + displayName + '\'' +
						", supportedLanguages=" + supportedLanguages +
						'}';
			}
		}

	public record SupportedLanguage(String isoCode, String displayName) {


		@Override
			public String toString() {
				return "SupportedLanguage{" +
						"isoCode='" + isoCode + '\'' +
						", displayName='" + displayName + '\'' +
						'}';
			}
		}

	public record NextInvoice(int amountDueCents, long nextPaymentAttemptUnix) {


		public Date getNextPaymentAttempt() {
				return new Date(nextPaymentAttemptUnix);
			}

			@Override
			public String toString() {
				return "NextInvoice{" +
						"amountDueCents=" + amountDueCents +
						", nextPaymentAttemptUnix=" + nextPaymentAttemptUnix +
						'}';
			}
		}
}
