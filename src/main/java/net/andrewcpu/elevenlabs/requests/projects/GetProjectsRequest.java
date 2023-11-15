package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.response.ProjectsModelResponse;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetProjectsRequest extends GetRequest<ProjectsModelResponse> {
	public GetProjectsRequest() {
		super("v1/projects", ProjectsModelResponse.class);
	}
}
