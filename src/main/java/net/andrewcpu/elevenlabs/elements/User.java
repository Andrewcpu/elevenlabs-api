package net.andrewcpu.elevenlabs.elements;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONObject;

import java.io.IOException;

public class User {
	private Subscription subscription;
	private boolean isNewUser;
	private String apiKey;

	public static User getUser() throws ElevenLabsValidationException, IOException {
		return ElevenLabsAPI.getInstance().getUser();
	}

	public User(Subscription subscription, boolean isNewUser, String xiApiKey) {
		this.subscription = subscription;
		this.isNewUser = isNewUser;
		this.apiKey = xiApiKey;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public boolean isNewUser() {
		return isNewUser;
	}

	public String getAPIKey() {
		return apiKey;
	}

	public History getHistory() throws IOException, ElevenLabsValidationException {
		return ElevenLabsAPI.getInstance().getHistory();
	}
	public static User fromJSON(JSONObject object) {
		JSONObject subscriptionJson = (JSONObject) object.get("subscription");
		Subscription subscription = Subscription.fromJSON(subscriptionJson);
		boolean isNewUser = (boolean) object.get("is_new_user");
		String xiApiKey = (String) object.get("xi_api_key");
		return new User(subscription, isNewUser, xiApiKey);
	}

	@Override
	public String toString() {
		return "User{" +
				"subscription=" + subscription +
				", isNewUser=" + isNewUser +
				", apiKey='" + apiKey + '\'' +
				'}';
	}
}
