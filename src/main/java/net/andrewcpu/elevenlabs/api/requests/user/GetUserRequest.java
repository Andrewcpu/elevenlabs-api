package net.andrewcpu.elevenlabs.api.requests.user;

import net.andrewcpu.elevenlabs.elements.user.User;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import org.json.simple.JSONObject;

public class GetUserRequest extends ElevenLabsRequest<User> {
	public GetUserRequest() {
		super(HTTPMethod.GET, new ResultTransformerAdapter<User>(){
			@Override
			public User transform(JSONObject object) {
				return User.fromJSON(object);
			}
		});
	}

	@Override
	public String getEndpoint() {
		return "v1/user";
	}
}
