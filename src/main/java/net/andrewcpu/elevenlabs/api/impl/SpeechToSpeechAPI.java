package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.sts.PostSpeechToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.sts.PostSpeechToSpeechStreamedRequest;

import java.io.File;
import java.io.InputStream;

public class SpeechToSpeechAPI extends ElevenLabsAPI {
	public File generateSpeechToSpeech(String voiceId, VoiceSettings voiceSettings, String modelId, File audio) {
		return generateSpeechToSpeech(voiceId, voiceSettings, modelId, audio, StreamLatencyOptimization.getDefault());
	}

	public File generateSpeechToSpeech(String voiceId, VoiceSettings voiceSettings, String modelId, File audio, StreamLatencyOptimization latencyOptimization) {
		return sendRequest(new PostSpeechToSpeechRequest(voiceId, voiceSettings,audio, modelId, latencyOptimization));
	}

	public InputStream generateSpeechToSpeechStream(String voiceId, VoiceSettings voiceSettings, String modelId, File audio, StreamLatencyOptimization streamLatencyOptimization) {
		return sendRequest(new PostSpeechToSpeechStreamedRequest(voiceId, voiceSettings, audio, modelId, streamLatencyOptimization));
	}

	public InputStream generateSpeechToSpeechStream(String voiceId, VoiceSettings voiceSettings, String modelId, File audio) {
		return generateSpeechToSpeechStream(voiceId, voiceSettings, modelId, audio, StreamLatencyOptimization.getDefault());
	}
}
