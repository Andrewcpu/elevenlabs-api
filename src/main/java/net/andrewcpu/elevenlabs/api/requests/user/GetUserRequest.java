package net.andrewcpu.elevenlabs.api.requests.user;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
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
