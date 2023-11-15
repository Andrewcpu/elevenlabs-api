package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetChapterSnapshotsRequest extends GetRequest<GetChapterSnapshotsRequest> {
	public GetChapterSnapshotsRequest(String projectId, String chapterId) {
		super("v1/projects/" + projectId + "/chapters/" + chapterId + "/snapshots", GetChapterSnapshotsRequest.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
