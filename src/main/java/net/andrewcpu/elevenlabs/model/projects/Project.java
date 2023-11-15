package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.request.AddProjectRequest;

import java.util.List;

public class Project extends ElevenModel {

	public static List<Project> getProjects() {
		return ElevenLabs.getProjectsAPI().getProjects();
	}

	public static Project addProject(AddProjectRequest builder) {
		return ElevenLabs.getProjectsAPI().addProject(builder);
	}

	public static Project getProjectById(String projectId) {
		return ElevenLabs.getProjectsAPI().getProject(projectId);
	}

	public List<Chapter> fetchUpdatedChapters() {
		this.chapters = ElevenLabs.getProjectsAPI().getChapters(projectId);
		return this.chapters;
	}

	public String deleteChapter(Chapter chapter) {
		return chapter.deleteChapter(projectId);
	}

	public String convertChapter(Chapter chapter) {
		return chapter.convertChapter(projectId);
	}

	public List<ChapterSnapshot> getChapterSnapshots(Chapter chapter) {
		return chapter.getChapterSnapshots(projectId);
	}

	public String deleteProject() {
		return ElevenLabs.getProjectsAPI().deleteProject(projectId);
	}

	public String convertProject() {
		return ElevenLabs.getProjectsAPI().convertProject(projectId);
	}

	public List<ProjectSnapshot> getSnapshots() {
		return ElevenLabs.getProjectsAPI().getProjectSnapshots(projectId);
	}

	public Chapter getChapterById(String chapterId) {
		return ElevenLabs.getProjectsAPI().getChapterById(projectId, chapterId);
	}

	public Project(String projectId, String name, long unixCreateDate, String defaultTitleVoiceId, String defaultParagraphVoiceId, String defaultModelId, long lastConversionDateUnix, boolean canBeDownloaded, String state, List<Chapter> chapters) {
		this.projectId = projectId;
		this.name = name;
		this.unixCreateDate = unixCreateDate;
		this.defaultTitleVoiceId = defaultTitleVoiceId;
		this.defaultParagraphVoiceId = defaultParagraphVoiceId;
		this.defaultModelId = defaultModelId;
		this.lastConversionDateUnix = lastConversionDateUnix;
		this.canBeDownloaded = canBeDownloaded;
		this.state = state;
		this.chapters = chapters;
	}

	public Project() {
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
