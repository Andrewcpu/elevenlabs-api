package net.andrewcpu.elevenlabs.api.requests.user;

import net.andrewcpu.elevenlabs.elements.user.Subscription;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

public class GetSubscriptionInfoRequest extends ElevenLabsRequest<Subscription> {
	public GetSubscriptionInfoRequest() {
		super(HTTPMethod.GET, new ResultTransformerAdapter<Subscription>(){
			@Override
			public Subscription transform(JSONObject object) {
				return Subscription.fromJSON(object);
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/user/subscription";
	}
}
