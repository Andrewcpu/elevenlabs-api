package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.InputStream;

public class PostStreamProjectSnapshotAudioRequest extends PostRequest<InputStream> {
	public PostStreamProjectSnapshotAudioRequest(String projectId, String snapshotId) {
		super("v1/projects/" + projectId + "/snapshots/" + snapshotId + "/stream", InputStream.class);
	}
}
