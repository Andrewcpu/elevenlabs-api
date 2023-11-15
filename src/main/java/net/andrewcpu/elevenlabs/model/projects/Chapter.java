package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class Chapter extends ElevenModel {

	public String deleteChapter(String projectId) {
		return ElevenLabs.getProjectsAPI().deleteChapter(projectId, chapterId);
	}

	public String convertChapter(String projectId) {
		return ElevenLabs.getProjectsAPI().convertChapter(projectId, chapterId);
	}

	public List<ChapterSnapshot> getChapterSnapshots(String projectId) {
		return ElevenLabs.getProjectsAPI().getChapterSnapshots(projectId, chapterId);
	}


	@JsonProperty("chapter_id")
	private String chapterId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("last_conversion_date_unix")
	private long lastConversionDateUnix;

	@JsonProperty("conversion_progress")
	private double conversionProgress;

	@JsonProperty("can_be_downloaded")
	private boolean canBeDownloaded;

	@JsonProperty("state")
	private String state;

	@JsonProperty("statistics")
	private Statistics statistics;

	public Chapter() {
	}

	public Chapter(String chapterId, String name, long lastConversionDateUnix, double conversionProgress, boolean canBeDownloaded, String state, Statistics statistics) {
		this.chapterId = chapterId;
		this.name = name;
		this.lastConversionDateUnix = lastConversionDateUnix;
		this.conversionProgress = conversionProgress;
		this.canBeDownloaded = canBeDownloaded;
		this.state = state;
		this.statistics = statistics;
	}

	@JsonIgnore
	public String getChapterId() {
		return chapterId;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@JsonIgnore
	public long getLastConversionDateUnix() {
		return lastConversionDateUnix;
	}

	@JsonIgnore
	public double getConversionProgress() {
		return conversionProgress;
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
	public Statistics getStatistics() {
		return statistics;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Chapter{" +
				"chapterId='" + chapterId + '\'' +
				", name='" + name + '\'' +
				", lastConversionDateUnix=" + lastConversionDateUnix +
				", conversionProgress=" + conversionProgress +
				", canBeDownloaded=" + canBeDownloaded +
				", state='" + state + '\'' +
				", statistics=" + statistics +
				'}';
	}
}
