package net.andrewcpu.elevenlabs.elements;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.enums.Status;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Subscription {
	private String tier;
	private int characterCount;
	private int characterLimit;
	private boolean canExtendCharacterLimit;
	private boolean allowedToExtendCharacterLimit;
	private long nextCharacterCountResetUnix;
	private int voiceLimit;
	private boolean canExtendVoiceLimit;
	private boolean canUseInstantVoiceCloning;
	private List<AvailableModel> availableModels;
	private Status status;
	private NextInvoice nextInvoice;

	public static Subscription getSubscription() throws ElevenLabsValidationException, IOException {
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

	public static class AvailableModel {
		private String modelId;
		private String displayName;
		private List<SupportedLanguage> supportedLanguages;

		public AvailableModel(String modelId, String displayName, List<SupportedLanguage> supportedLanguages) {
			this.modelId = modelId;
			this.displayName = displayName;
			this.supportedLanguages = supportedLanguages;
		}

		public String getModelId() {
			return modelId;
		}

		public String getDisplayName() {
			return displayName;
		}

		public List<SupportedLanguage> getSupportedLanguages() {
			return supportedLanguages;
		}

		@Override
		public String toString() {
			return "AvailableModel{" +
					"modelId='" + modelId + '\'' +
					", displayName='" + displayName + '\'' +
					", supportedLanguages=" + supportedLanguages +
					'}';
		}
	}

	public static class SupportedLanguage {
		private String isoCode;
		private String displayName;

		public SupportedLanguage(String isoCode, String displayName) {
			this.isoCode = isoCode;
			this.displayName = displayName;
		}

		public String getIsoCode() {
			return isoCode;
		}

		public String getDisplayName() {
			return displayName;
		}

		@Override
		public String toString() {
			return "SupportedLanguage{" +
					"isoCode='" + isoCode + '\'' +
					", displayName='" + displayName + '\'' +
					'}';
		}
	}

	public static class NextInvoice {
		private int amountDueCents;
		private long nextPaymentAttemptUnix;

		public NextInvoice(int amountDueCents, long nextPaymentAttemptUnix) {
			this.amountDueCents = amountDueCents;
			this.nextPaymentAttemptUnix = nextPaymentAttemptUnix;
		}

		public int getAmountDueCents() {
			return amountDueCents;
		}

		public long getNextPaymentAttemptUnix() {
			return nextPaymentAttemptUnix;
		}

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
