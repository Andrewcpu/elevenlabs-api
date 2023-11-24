package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.PostRequest;

public class PostConvertChapterRequest extends PostRequest<String> {
	public PostConvertChapterRequest(String projectId, String chapterId) {
		super("v1/projects/" + projectId + "/chapters/" + chapterId + "/convert", String.class);
	}
}
