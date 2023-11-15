package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.projects.Project;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetProjectByIdRequest extends GetRequest<Project> {
	public GetProjectByIdRequest(String projectId) {
		super("v1/projects/" + projectId, Project.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
