package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.response.ChaptersModelResponse;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetProjectChaptersRequest extends GetRequest<ChaptersModelResponse> {
	public GetProjectChaptersRequest(String projectId) {
		super("v1/projects/" + projectId + "/chapters", ChaptersModelResponse.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
