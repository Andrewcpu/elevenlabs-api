package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.user.Subscription;
import net.andrewcpu.elevenlabs.model.user.User;
import net.andrewcpu.elevenlabs.requests.user.GetSubscriptionRequest;
import net.andrewcpu.elevenlabs.requests.user.GetUserRequest;

public class UserAPI extends ElevenLabsAPI {


	public User getUser() {
		return sendRequest(new GetUserRequest());
	}

	public Subscription getSubscription() {
		return sendRequest(new GetSubscriptionRequest());
	}
}
