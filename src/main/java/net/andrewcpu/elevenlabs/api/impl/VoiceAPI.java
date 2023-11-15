package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.response.CreateVoiceResponse;
import net.andrewcpu.elevenlabs.model.response.ProjectsModelResponse;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.projects.GetProjectsRequest;
import net.andrewcpu.elevenlabs.requests.voices.*;

import java.io.File;
import java.util.List;
import java.util.Map;

public class VoiceAPI extends ElevenLabsAPI {

	public List<Voice> getVoices() {
		return sendRequest(new GetVoicesRequest()).getVoices();
	}

	public VoiceSettings getDefaultVoiceSettings() {
		return sendRequest(new GetDefaultVoiceSettingsRequest());
	}

	public VoiceSettings getVoiceSettings(String voiceId) {
		return sendRequest(new GetVoiceSettingsRequest(voiceId));
	}

	public Voice getVoice(String voiceId) {
		return sendRequest(new GetVoiceRequest(voiceId));
	}

	public Voice getVoice(String voiceId, boolean withSettings) {
		return sendRequest(new GetVoiceRequest(voiceId, withSettings));
	}

	public ProjectsModelResponse getProjects() {
		return sendRequest(new GetProjectsRequest());
	}

	public String deleteVoice(String voiceId) {
		return sendRequest(new DeleteVoiceRequest(voiceId));
	}

	public String editVoiceSettings(String voiceId, VoiceSettings settings) {
		return sendRequest(new PostEditVoiceSettingsRequest(voiceId, settings));
	}

	public CreateVoiceResponse createVoice(String name, File[] files, String description, Map<String, String> labels) {
		return sendRequest(new PostAddVoiceRequest(name, files, description, labels));
	}
	public String editVoice(String voiceId, String name, File[] files, String description, Map<String, String> labels) {
		return sendRequest(new PostEditVoiceRequest(voiceId, name, files, description, labels));
	}
}
