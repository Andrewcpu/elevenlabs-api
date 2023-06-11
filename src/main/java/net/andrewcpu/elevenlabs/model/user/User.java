package net.andrewcpu.elevenlabs.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class User extends ElevenModel {

	public static User get() {
		return ElevenLabs.getUser();
	}

	@JsonProperty("subscription")
	private Subscription subscription;

	@JsonProperty("is_new_user")
	private boolean isNewUser;

	@JsonProperty("xi_api_key")
	private String xiApiKey;

	@JsonProperty("can_use_delayed_payment_methods")
	private boolean canUseDelayedPaymentMethods;

	public User(Subscription subscription, boolean isNewUser, String xiApiKey, boolean canUseDelayedPaymentMethods) {
		this.subscription = subscription;
		this.isNewUser = isNewUser;
		this.xiApiKey = xiApiKey;
		this.canUseDelayedPaymentMethods = canUseDelayedPaymentMethods;
	}

	public User() {
	}

	@JsonIgnore
	public Subscription getSubscription() {
		return subscription;
	}

	@JsonIgnore
	public boolean isNewUser() {
		return isNewUser;
	}

	@JsonIgnore
	public String getXiApiKey() {
		return xiApiKey;
	}

	@JsonIgnore
	public boolean isCanUseDelayedPaymentMethods() {
		return canUseDelayedPaymentMethods;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "User{" +
				"subscription=" + subscription +
				", isNewUser=" + isNewUser +
				", xiApiKey='" + xiApiKey + '\'' +
				", canUseDelayedPaymentMethods=" + canUseDelayedPaymentMethods +
				'}';
	}
}
