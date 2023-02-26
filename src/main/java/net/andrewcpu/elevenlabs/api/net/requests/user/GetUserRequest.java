package net.andrewcpu.elevenlabs.api.net.requests.user;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.user.User;

public class GetUserRequest extends ElevenLabsGetRequest<User> {
	public GetUserRequest() {
		super(RequestTransformer.USER_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "user";
	}
}
