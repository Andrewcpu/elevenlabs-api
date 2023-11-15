package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Chapter extends ElevenModel {
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
}
