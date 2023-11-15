package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.tts.PostTextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.tts.PostTextToSpeechStreamedRequest;

import java.io.File;
import java.io.InputStream;

public class TextToSpeechAPI extends ElevenLabsAPI {

	public File generateTextToSpeech(String voiceId, String text, String modelId, VoiceSettings voiceSettings) {
		return sendRequest(new PostTextToSpeechRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings)));
	}

	public File generateTextToSpeech(String voiceId, String text, String modelId, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization, VoiceSettings voiceSettings) {
		return sendRequest(new PostTextToSpeechRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings), streamLatencyOptimization, outputFormat));
	}
	public InputStream generateTextToSpeechStreamed(String voiceId, String text, String modelId, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization, VoiceSettings voiceSettings) {
		return sendRequest(new PostTextToSpeechStreamedRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings), streamLatencyOptimization, outputFormat));
	}

	public InputStream generateTextToSpeechStreamed(String voiceId, String text, String modelId, VoiceSettings voiceSettings) {
		return sendRequest(new PostTextToSpeechStreamedRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings)));
	}

}
