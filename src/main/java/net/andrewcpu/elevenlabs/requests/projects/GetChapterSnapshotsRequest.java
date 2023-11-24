package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.response.ChapterSnapshotsModelResponse;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetChapterSnapshotsRequest extends GetRequest<ChapterSnapshotsModelResponse> {
	public GetChapterSnapshotsRequest(String projectId, String chapterId) {
		super("v1/projects/" + projectId + "/chapters/" + chapterId + "/snapshots", ChapterSnapshotsModelResponse.class);
	}
}
