package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.InputStream;

public class PostStreamChapterSnapshotAudioRequest extends PostRequest<InputStream> {
	public PostStreamChapterSnapshotAudioRequest(String projectId, String chapterId, String chapterSnapshotId) {
		super("v1/projects/" + projectId + "/chapters/" + chapterId + "/snapshots/" + chapterSnapshotId + "/stream", InputStream.class);
	}

}
