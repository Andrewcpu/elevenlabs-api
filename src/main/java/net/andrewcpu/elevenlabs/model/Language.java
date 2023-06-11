package net.andrewcpu.elevenlabs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {
	@JsonProperty("language_id")
	private String languageId;

	@JsonProperty("name")
	private String name;

	public Language(String languageId, String name) {
		this.languageId = languageId;
		this.name = name;
	}

	public Language() {
	}

	@JsonIgnore
	public String getLanguageId() {
		return languageId;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Language{" +
				"languageId='" + languageId + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
