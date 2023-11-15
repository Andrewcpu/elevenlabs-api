package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class ProjectSnapshot extends ElevenModel {
	public ProjectSnapshot() {
	}

	public ProjectSnapshot(String projectSnapshotId, String projectId, long createdAtUnix, String name) {
		this.projectSnapshotId = projectSnapshotId;
		this.projectId = projectId;
		this.createdAtUnix = createdAtUnix;
		this.name = name;
	}

	@JsonProperty("project_snapshot_id")
	private String projectSnapshotId;

	@JsonProperty("project_id")
	private String projectId;

	@JsonProperty("created_at_unix")
	private long createdAtUnix;

	@JsonProperty("name")
	private String name;

	@JsonIgnore
	public String getProjectSnapshotId() {
		return projectSnapshotId;
	}

	@JsonIgnore
	public String getProjectId() {
		return projectId;
	}

	@JsonIgnore
	public long getCreatedAtUnix() {
		return createdAtUnix;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Snapshot{" +
				"projectSnapshotId='" + projectSnapshotId + '\'' +
				", projectId='" + projectId + '\'' +
				", createdAtUnix=" + createdAtUnix +
				", name='" + name + '\'' +
				'}';
	}
}
