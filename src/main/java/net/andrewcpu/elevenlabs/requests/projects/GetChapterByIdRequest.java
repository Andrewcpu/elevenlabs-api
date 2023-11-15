package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.projects.Chapter;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetChapterByIdRequest extends GetRequest<Chapter> {
	public GetChapterByIdRequest(String projectId, String chapterId) {
		super("v1/projects/" + projectId + "/chapters/" + chapterId, Chapter.class);
	}
}
