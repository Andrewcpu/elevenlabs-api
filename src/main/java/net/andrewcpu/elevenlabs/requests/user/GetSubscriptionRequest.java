package net.andrewcpu.elevenlabs.requests.user;

import net.andrewcpu.elevenlabs.model.user.Subscription;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetSubscriptionRequest extends GetRequest<Subscription> {
	public GetSubscriptionRequest() {
		super("v1/user/subscription", Subscription.class);
	}
}
