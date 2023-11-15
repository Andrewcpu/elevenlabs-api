package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class Project extends ElevenModel {

	public static List<Project> getProjects() {
		return ElevenLabs.getProjectsAPI().getProjects();
	}

	@JsonProperty("project_id")
	private String projectId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("create_date_unix")
	private long unixCreateDate;

	@JsonProperty("default_title_voice_id")
	private String defaultTitleVoiceId;

	@JsonProperty("default_paragraph_voice_id")
	private String defaultParagraphVoiceId;

	@JsonProperty("default_model_id")
	private String defaultModelId;

	@JsonProperty("last_conversion_date_unix")
	private long lastConversionDateUnix;

	@JsonProperty("can_be_downloaded")
	private boolean canBeDownloaded;

	@JsonProperty("state")
	private String state;

	@JsonProperty("chapters")
	private List<Chapter> chapters;


	@JsonIgnore
	public String getProjectId() {
		return projectId;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@JsonIgnore
	public long getUnixCreateDate() {
		return unixCreateDate;
	}

	@JsonIgnore
	public String getDefaultTitleVoiceId() {
		return defaultTitleVoiceId;
	}

	@JsonIgnore
	public String getDefaultParagraphVoiceId() {
		return defaultParagraphVoiceId;
	}

	@JsonIgnore
	public String getDefaultModelId() {
		return defaultModelId;
	}

	@JsonIgnore
	public long getLastConversionDateUnix() {
		return lastConversionDateUnix;
	}

	@JsonIgnore
	public boolean isCanBeDownloaded() {
		return canBeDownloaded;
	}

	@JsonIgnore
	public String getState() {
		return state;
	}

	@JsonIgnore
	public List<Chapter> getChapters() {
		return chapters;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Project{" +
				"projectId='" + projectId + '\'' +
				", name='" + name + '\'' +
				", unixCreateDate=" + unixCreateDate +
				", defaultTitleVoiceId='" + defaultTitleVoiceId + '\'' +
				", defaultParagraphVoiceId='" + defaultParagraphVoiceId + '\'' +
				", defaultModelId='" + defaultModelId + '\'' +
				", lastConversionDateUnix=" + lastConversionDateUnix +
				", canBeDownloaded=" + canBeDownloaded +
				", state='" + state + '\'' +
				", chapters=" + chapters +
				'}';
	}
}
