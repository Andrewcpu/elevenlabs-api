package net.andrewcpu.elevenlabs.model.voice;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.response.CreateVoiceResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoiceBuilder {
	public static VoiceBuilder fromVoice(Voice voice) {
		VoiceBuilder voiceBuilder = new VoiceBuilder(voice);
		return voiceBuilder;
	}

	private Voice voice;
	private String name;
	private String description;
	private Map<String, String> labels;
	private List<File> files;

	public VoiceBuilder() {
		this.labels = new HashMap<>();
		this.files = new ArrayList<>();
	}

	public VoiceBuilder(Voice voice) {
		this();
		this.voice = voice;
		this.name = voice.getName();
		this.description = voice.getDescription();
		this.labels = voice.getLabels();
	}

	public String getName() {
		return name;
	}

	public VoiceBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public VoiceBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public VoiceBuilder withLabels(Map<String, String> labels) {
		this.labels = labels;
		return this;
	}

	public VoiceBuilder withLabel(String key, String value) {
		this.labels.put(key, value);
		return this;
	}

	public List<File> getFiles() {
		return files;
	}

	public VoiceBuilder withFile(File file) {
		this.files.add(file);
		return this;
	}

	public VoiceBuilder withFiles(List<File> files) {
		this.files = files;
		return this;
	}

	public Voice create() {
		CreateVoiceResponse createVoiceResponse = ElevenLabs.createVoice(name, files.toArray(File[]::new), description, labels);
		return Voice.getVoice(createVoiceResponse.getVoiceId(), true);
	}

	public Voice edit() {
		ElevenLabs.editVoice(voice.getVoiceId(), name, files.toArray(File[]::new), description, labels);
		voice = voice.refresh();
		return voice;
	}
}
