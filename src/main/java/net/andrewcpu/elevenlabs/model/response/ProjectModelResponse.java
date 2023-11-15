package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.projects.Project;

public class ProjectModelResponse extends ElevenModel {
	@JsonProperty("project")
	private Project project;

	public ProjectModelResponse(Project project) {
		this.project = project;
	}

	public ProjectModelResponse() {
	}

	@JsonIgnore
	public Project getProject() {
		return project;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "ProjectModelResponse{" +
				"project=" + project +
				'}';
	}
}
