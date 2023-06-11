package net.andrewcpu.elevenlabs.net.user;

import net.andrewcpu.elevenlabs.model.user.Subscription;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetSubscriptionRequest extends GetRequest<Subscription> {

	public GetSubscriptionRequest() {
		super("v1/user/subscription", Subscription.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
