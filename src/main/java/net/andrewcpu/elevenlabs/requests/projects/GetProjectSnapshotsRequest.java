package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.response.ProjectSnapshotsModelResponse;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetProjectSnapshotsRequest extends GetRequest<ProjectSnapshotsModelResponse> {
	public GetProjectSnapshotsRequest(String projectId) {
		super("v1/projects/" + projectId + "/snapshots", ProjectSnapshotsModelResponse.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
