package net.andrewcpu.elevenlabs.requests.user;

import net.andrewcpu.elevenlabs.model.user.User;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetUserRequest extends GetRequest<User> {
	public GetUserRequest() {
		super("v1/user", User.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
