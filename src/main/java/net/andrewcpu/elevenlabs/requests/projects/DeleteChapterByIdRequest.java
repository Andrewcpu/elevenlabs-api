package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.DeleteRequest;

public class DeleteChapterByIdRequest extends DeleteRequest<String> {

	public DeleteChapterByIdRequest(String projectId, String chapterId) {
		super("v1/projects/" + projectId + "/chapters/" + chapterId, String.class);
	}
}
