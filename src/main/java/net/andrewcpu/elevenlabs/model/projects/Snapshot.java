package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.io.InputStream;

public abstract class Snapshot extends ElevenModel {
	@JsonProperty("project_id")
	protected String projectId;

	@JsonProperty("created_at_unix")
	protected long createdAtUnix;

	@JsonProperty("name")
	protected String name;

	public Snapshot(String projectId, long createdAtUnix, String name) {
		this.projectId = projectId;
		this.createdAtUnix = createdAtUnix;
		this.name = name;
	}

	public Snapshot() {
	}

	public abstract InputStream getAudioStream();

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
				"projectId='" + projectId + '\'' +
				", createdAtUnix=" + createdAtUnix +
				", name='" + name + '\'' +
				'}';
	}
}
