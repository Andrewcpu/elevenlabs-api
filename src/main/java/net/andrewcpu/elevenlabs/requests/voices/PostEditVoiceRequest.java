package net.andrewcpu.elevenlabs.requests.voices;

import net.andrewcpu.elevenlabs.requests.PostMultipartRequest;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PostEditVoiceRequest extends PostMultipartRequest<String> {
	private final String name;
	private final File[] samples;
	private final String description;
	private final Map<String, String> labels;
	public PostEditVoiceRequest(String voiceId, String name, File[] samples, String description, Map<String, String> labels) {
		super("v1/voices/" + voiceId + "/edit", String.class);
		this.name = name;
		this.samples = samples;
		this.description = description;
		this.labels = labels;
	}

	public String getName() {
		return name;
	}

	public File[] getSamples() {
		return samples;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	@Override
	public Map<String, Object> getMultipartParts(Map<String, Object> map) {
		map.put("name", this.name);
		map.put("files", this.samples);
		map.put("description", this.description);
		map.put("labels", this.labels);
		return map;
	}
}
