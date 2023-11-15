package net.andrewcpu.elevenlabs.model.request;

import net.andrewcpu.elevenlabs.model.ElevenModel;

import javax.management.loading.PrivateClassLoader;
import java.io.File;

public class CreateAudioNativeProjectRequest extends ElevenModel {
	private String name;
	private String image;
	private String author;
	private boolean small;
	private String textColor;
	private String backgroundColor;
	private Integer sessionization;
	private String voiceId;
	private String modelId;
	private File file;
	private boolean autoConvert;

	public String getName() {
		return name;
	}

	public CreateAudioNativeProjectRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getImage() {
		return image;
	}

	public CreateAudioNativeProjectRequest setImage(String image) {
		this.image = image;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public CreateAudioNativeProjectRequest setAuthor(String author) {
		this.author = author;
		return this;
	}

	public boolean isSmall() {
		return small;
	}

	public CreateAudioNativeProjectRequest setSmall(boolean small) {
		this.small = small;
		return this;
	}

	public String getTextColor() {
		return textColor;
	}

	public CreateAudioNativeProjectRequest setTextColor(String textColor) {
		this.textColor = textColor;
		return this;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public CreateAudioNativeProjectRequest setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
		return this;
	}

	public Integer getSessionization() {
		return sessionization;
	}

	public CreateAudioNativeProjectRequest setSessionization(Integer sessionization) {
		this.sessionization = sessionization;
		return this;
	}

	public String getVoiceId() {
		return voiceId;
	}

	public CreateAudioNativeProjectRequest setVoiceId(String voiceId) {
		this.voiceId = voiceId;
		return this;
	}

	public String getModelId() {
		return modelId;
	}

	public CreateAudioNativeProjectRequest setModelId(String modelId) {
		this.modelId = modelId;
		return this;
	}

	public File getFile() {
		return file;
	}

	public CreateAudioNativeProjectRequest setFile(File file) {
		this.file = file;
		return this;
	}

	public boolean isAutoConvert() {
		return autoConvert;
	}

	public CreateAudioNativeProjectRequest setAutoConvert(boolean autoConvert) {
		this.autoConvert = autoConvert;
		return this;
	}
}
