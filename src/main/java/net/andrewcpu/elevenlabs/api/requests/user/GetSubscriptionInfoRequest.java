package net.andrewcpu.elevenlabs.api.requests.user;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.SubscriptionTransformer;
import net.andrewcpu.elevenlabs.elements.user.Subscription;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

public class GetSubscriptionInfoRequest extends ElevenLabsRequest<Subscription> {
	public GetSubscriptionInfoRequest() {
		super(HTTPMethod.GET, new SubscriptionTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/user/subscription";
	}
}
