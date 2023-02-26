package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.api.net.requests.user.GetSubscriptionInfoRequest;
import net.andrewcpu.elevenlabs.api.net.requests.user.GetUserRequest;
import net.andrewcpu.elevenlabs.elements.user.Subscription;
import net.andrewcpu.elevenlabs.elements.user.User;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;

import static net.andrewcpu.elevenlabs.ElevenLabsAPI.getRequestResult;

public class UserAPI {
	public static Subscription getSubscription() throws ElevenLabsException {
		return getRequestResult(new GetSubscriptionInfoRequest());
	}

	public static User getUser() throws ElevenLabsException {
		return getRequestResult(new GetUserRequest());
	}

}
