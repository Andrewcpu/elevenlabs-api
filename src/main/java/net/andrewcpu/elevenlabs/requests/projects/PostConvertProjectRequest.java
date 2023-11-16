package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.PostRequest;

public class PostConvertProjectRequest extends PostRequest<String> {
	public PostConvertProjectRequest(String projectId) {
		super("v1/projects/" + projectId + "/convert", String.class);
	}

}
