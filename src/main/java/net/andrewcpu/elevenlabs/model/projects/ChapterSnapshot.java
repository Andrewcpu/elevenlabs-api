package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.io.InputStream;

public class ChapterSnapshot extends ElevenModel {

	public InputStream getAudioStream() {
		return ElevenLabs.getProjectsAPI().getChapterSnapshotAudioStream(projectId, chapterId, chapterSnapshotId);
	}

	public ChapterSnapshot() {
	}

	public ChapterSnapshot(String chapterSnapshotId, String projectId, String chapterId, long createdAtUnix, String name) {
		this.chapterSnapshotId = chapterSnapshotId;
		this.projectId = projectId;
		this.chapterId = chapterId;
		this.createdAtUnix = createdAtUnix;
		this.name = name;
	}

	@JsonProperty("chapter_snapshot_id")
	private String chapterSnapshotId;

	@JsonProperty("project_id")
	private String projectId;

	@JsonProperty("chapter_id")
	private String chapterId;

	@JsonProperty("created_at_unix")
	private long createdAtUnix;

	@JsonProperty("name")
	private String name;

	@JsonIgnore
	public String getChapterSnapshotId() {
		return chapterSnapshotId;
	}
	@JsonIgnore
	public String getChapterId() {
		return chapterId;
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
		return "ChapterSnapshot{" +
				"chapterSnapshotId='" + chapterSnapshotId + '\'' +
				", projectId='" + projectId + '\'' +
				", chapterId='" + chapterId + '\'' +
				", createdAtUnix=" + createdAtUnix +
				", name='" + name + '\'' +
				'}';
	}
}
