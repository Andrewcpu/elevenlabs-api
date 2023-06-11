package net.andrewcpu.elevenlabs.net.voices;

import net.andrewcpu.elevenlabs.model.response.CreateVoiceResponse;
import net.andrewcpu.elevenlabs.net.PostRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PostEditVoiceRequest extends PostRequest<String> {
	private String name;
	private File[] samples;
	private String description;
	private Map<String, String> labels;
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
	public Object getPayload() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", this.name);
		map.put("files", this.samples);
		map.put("description", this.description);
		map.put("labels", this.labels);
		return map;
	}
}
