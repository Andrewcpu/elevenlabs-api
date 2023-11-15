package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.projects.Chapter;

import java.util.List;

public class ChaptersModelResponse extends ElevenModel {
	@JsonProperty("chapters")
	private List<Chapter> chapters;

	public ChaptersModelResponse(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public ChaptersModelResponse() {
	}

	@JsonIgnore
	public List<Chapter> getChapters() {
		return chapters;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "ChaptersModelResponse{" +
				"chapters=" + chapters +
				'}';
	}
}
