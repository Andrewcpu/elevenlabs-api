package net.andrewcpu.elevenlabs.api.net.requests.user;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.user.Subscription;

public class GetSubscriptionInfoRequest extends ElevenLabsGetRequest<Subscription> {
	public GetSubscriptionInfoRequest() {
		super(RequestTransformer.SUBSCRIPTION_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "user/subscription";
	}
}
