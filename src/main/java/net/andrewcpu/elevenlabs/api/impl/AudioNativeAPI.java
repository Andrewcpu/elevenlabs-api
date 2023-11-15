package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.request.CreateAudioNativeProjectRequest;
import net.andrewcpu.elevenlabs.model.response.CreateAudioEnabledProjectModelResponse;
import net.andrewcpu.elevenlabs.requests.audionative.PostCreateAudioNativeProjectRequest;

public class AudioNativeAPI extends ElevenLabsAPI {
	public CreateAudioEnabledProjectModelResponse createAudioEnabledProject(CreateAudioNativeProjectRequest request) {
		return sendRequest(new PostCreateAudioNativeProjectRequest(request));
	}
}
