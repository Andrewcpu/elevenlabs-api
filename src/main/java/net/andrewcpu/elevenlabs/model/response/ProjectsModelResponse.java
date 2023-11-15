package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.projects.Project;

import java.util.List;

public class ProjectsModelResponse extends ElevenModel {
	@JsonProperty("projects")
	private List<Project> projects;

	public ProjectsModelResponse(List<Project> projects) {
		this.projects = projects;
	}

	public ProjectsModelResponse() {
	}

	@JsonIgnore
	public List<Project> getProjects() {
		return projects;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "ProjectsModelResponse{" +
				"projects=" + projects +
				'}';
	}
}
