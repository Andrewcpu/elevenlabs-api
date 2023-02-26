package net.andrewcpu.elevenlabs.api.net.transformers.obj;

import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.elements.user.Subscription;
import org.json.simple.JSONObject;

public class SubscriptionTransformer extends ResultTransformerAdapter<Subscription> {
	@Override
	public Subscription transform(JSONObject object) {
		return Subscription.fromJSON(object);
	}
}
