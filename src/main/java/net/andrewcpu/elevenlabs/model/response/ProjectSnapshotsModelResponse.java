package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.projects.ProjectSnapshot;

import java.util.List;

public class ProjectSnapshotsModelResponse extends ElevenModel {
	@JsonProperty("snapshots")
	private List<ProjectSnapshot> projectSnapshots;


	public ProjectSnapshotsModelResponse(List<ProjectSnapshot> projectSnapshots) {
		this.projectSnapshots = projectSnapshots;
	}

	public ProjectSnapshotsModelResponse() {
	}

	@JsonIgnore
	public List<ProjectSnapshot> getSnapshots() {
		return projectSnapshots;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "ProjectSnapshotsModelResponse{" +
				"snapshots=" + projectSnapshots +
				'}';
	}
}
