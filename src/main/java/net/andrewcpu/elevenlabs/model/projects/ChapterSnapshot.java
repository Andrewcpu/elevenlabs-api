package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.io.InputStream;

public class ChapterSnapshot extends Snapshot {

	@Override
	public InputStream getAudioStream() {
		return ElevenLabs.getProjectsAPI().getChapterSnapshotAudioStream(projectId, chapterId, chapterSnapshotId);
	}

	public ChapterSnapshot() {
		super();
	}

	public ChapterSnapshot(String chapterSnapshotId, String projectId, String chapterId, long createdAtUnix, String name) {
		super(projectId, createdAtUnix, name);
		this.chapterSnapshotId = chapterSnapshotId;
		this.chapterId = chapterId;
	}

	@JsonProperty("chapter_snapshot_id")
	private String chapterSnapshotId;

	@JsonProperty("chapter_id")
	private String chapterId;


	@JsonIgnore
	public String getChapterSnapshotId() {
		return chapterSnapshotId;
	}
	@JsonIgnore
	public String getChapterId() {
		return chapterId;
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
