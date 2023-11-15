package net.andrewcpu.elevenlabs.model.request;

import net.andrewcpu.elevenlabs.enums.ProjectOutputQuality;

import java.io.File;
import java.lang.invoke.StringConcatFactory;

public class AddProjectRequest {
	private String name;
	private String fromUrl;
	private File fromDocument;
	private String defaultTitleVoiceId;
	private String defaultParagraphVoiceId;
	private String defaultModelId;
	private ProjectOutputQuality projectOutputQuality;
	private String title;
	private String author;
	private String isbnNumber;
	private boolean acxVolumeNormalization;

	public String getName() {
		return name;
	}

	public AddProjectRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getFromUrl() {
		return fromUrl;
	}

	public AddProjectRequest setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
		return this;
	}

	public File getFromDocument() {
		return fromDocument;
	}

	public AddProjectRequest setFromDocument(File fromDocument) {
		this.fromDocument = fromDocument;
		return this;
	}

	public String getDefaultTitleVoiceId() {
		return defaultTitleVoiceId;
	}

	public AddProjectRequest setDefaultTitleVoiceId(String defaultTitleVoiceId) {
		this.defaultTitleVoiceId = defaultTitleVoiceId;
		return this;
	}

	public String getDefaultParagraphVoiceId() {
		return defaultParagraphVoiceId;
	}

	public AddProjectRequest setDefaultParagraphVoiceId(String defaultParagraphVoiceId) {
		this.defaultParagraphVoiceId = defaultParagraphVoiceId;
		return this;
	}

	public String getDefaultModelId() {
		return defaultModelId;
	}

	public AddProjectRequest setDefaultModelId(String defaultModelId) {
		this.defaultModelId = defaultModelId;
		return this;
	}

	public ProjectOutputQuality getProjectOutputQuality() {
		return projectOutputQuality;
	}

	public AddProjectRequest setProjectOutputQuality(ProjectOutputQuality projectOutputQuality) {
		this.projectOutputQuality = projectOutputQuality;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public AddProjectRequest setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public AddProjectRequest setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public AddProjectRequest setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
		return this;
	}

	public boolean isAcxVolumeNormalization() {
		return acxVolumeNormalization;
	}

	public AddProjectRequest setAcxVolumeNormalization(boolean acxVolumeNormalization) {
		this.acxVolumeNormalization = acxVolumeNormalization;
		return this;
	}
}
