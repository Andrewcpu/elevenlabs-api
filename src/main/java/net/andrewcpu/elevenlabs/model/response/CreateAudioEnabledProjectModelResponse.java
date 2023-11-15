package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class CreateAudioEnabledProjectModelResponse extends ElevenModel {
	@JsonProperty("project_id")
	private String projectId;

	@JsonProperty("converting")
	private boolean converting;

	@JsonProperty("html_snippet")
	private String htmlSnippet;

	public CreateAudioEnabledProjectModelResponse(String projectId, boolean converting, String htmlSnippet) {
		this.projectId = projectId;
		this.converting = converting;
		this.htmlSnippet = htmlSnippet;
	}

	public CreateAudioEnabledProjectModelResponse() {
	}

	@JsonIgnore
	public String getProjectId() {
		return projectId;
	}

	@JsonIgnore
	public boolean isConverting() {
		return converting;
	}

	@JsonIgnore
	public String getHtmlSnippet() {
		return htmlSnippet;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "CreateAudioEnabledProjectModelResponse{" +
				"projectId='" + projectId + '\'' +
				", converting=" + converting +
				", htmlSnippet='" + htmlSnippet + '\'' +
				'}';
	}
}
