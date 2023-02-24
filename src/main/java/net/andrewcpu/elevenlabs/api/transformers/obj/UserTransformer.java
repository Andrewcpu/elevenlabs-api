package net.andrewcpu.elevenlabs.api.transformers.obj;

import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.elements.user.User;
import org.json.simple.JSONObject;

public class UserTransformer extends ResultTransformerAdapter<User> {
	@Override
	public User transform(JSONObject object) {
		return User.fromJSON(object);
	}
}
