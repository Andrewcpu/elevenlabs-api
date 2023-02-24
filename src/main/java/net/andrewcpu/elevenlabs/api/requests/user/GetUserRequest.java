package net.andrewcpu.elevenlabs.api.requests.user;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.UserTransformer;
import net.andrewcpu.elevenlabs.elements.user.User;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

public class GetUserRequest extends ElevenLabsRequest<User> {
	public GetUserRequest() {
		super(HTTPMethod.GET, new UserTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/user";
	}
}
