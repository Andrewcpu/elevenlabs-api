package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.io.InputStream;

public class ProjectSnapshot extends Snapshot {

	@Override
	public InputStream getAudioStream() {
		return ElevenLabs.getProjectsAPI().getProjectSnapshotAudioStream(projectId, projectSnapshotId);
	}

	public ProjectSnapshot() {
		super();
	}

	public ProjectSnapshot(String projectSnapshotId, String projectId, long createdAtUnix, String name) {
		super(projectId, createdAtUnix, name);
		this.projectSnapshotId = projectSnapshotId;
	}

	@JsonProperty("project_snapshot_id")
	private String projectSnapshotId;


	@JsonIgnore
	public String getProjectSnapshotId() {
		return projectSnapshotId;
	}


	@Override
	public String toString() {
		return "ProjectSnapshot{" +
				"projectSnapshotId='" + projectSnapshotId + '\'' +
				", projectId='" + projectId + '\'' +
				", createdAtUnix=" + createdAtUnix +
				", name='" + name + '\'' +
				'}';
	}
}
