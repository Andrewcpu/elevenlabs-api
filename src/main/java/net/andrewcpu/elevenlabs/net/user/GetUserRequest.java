package net.andrewcpu.elevenlabs.net.user;

import net.andrewcpu.elevenlabs.model.user.User;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetUserRequest extends GetRequest<User> {
	public GetUserRequest() {
		super("v1/user", User.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
