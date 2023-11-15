package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.DeleteRequest;

public class DeleteProjectByIdRequest extends DeleteRequest<String> {
	public DeleteProjectByIdRequest(String projectId) {
		super("v1/projects/" + projectId, String.class);
	}
}
