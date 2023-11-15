package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.api.impl.*;
import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import net.andrewcpu.elevenlabs.model.projects.Project;
import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.model.response.CreateVoiceResponse;
import net.andrewcpu.elevenlabs.model.response.GenerationTypeModel;
import net.andrewcpu.elevenlabs.model.response.ProjectsModelResponse;
import net.andrewcpu.elevenlabs.model.user.Subscription;
import net.andrewcpu.elevenlabs.model.user.User;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.requests.history.*;
import net.andrewcpu.elevenlabs.requests.models.GetModelsRequest;
import net.andrewcpu.elevenlabs.requests.projects.GetProjectsRequest;
import net.andrewcpu.elevenlabs.requests.samples.DeleteSampleRequest;
import net.andrewcpu.elevenlabs.requests.samples.GetSampleRequest;
import net.andrewcpu.elevenlabs.requests.tts.PostTextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.tts.PostTextToSpeechStreamedRequest;
import net.andrewcpu.elevenlabs.requests.user.GetSubscriptionRequest;
import net.andrewcpu.elevenlabs.requests.user.GetUserRequest;
import net.andrewcpu.elevenlabs.requests.voices.*;
import net.andrewcpu.elevenlabs.util.ElevenNetworkUtil;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ElevenLabs {
	private static String API_KEY = null;
	private static HistoryAPI historyAPI;
	private static ModelsAPI modelsAPI;
	private static ProjectsAPI projectsAPI;
	private static SampleAPI sampleAPI;
	private static SpeechToSpeechAPI speechToSpeechAPI;
	private static TextToSpeechAPI textToSpeechAPI;
	private static UserAPI userAPI;
	private static VoiceAPI voiceAPI;
	private static AudioNativeAPI audioNativeAPI;

	public static String getApiKey() {
		return API_KEY;
	}

	public static void setApiKey(String apiKey) {
		API_KEY = apiKey;
		initializeSubclasses();
	}

	private static void initializeSubclasses() {
		ElevenLabs.historyAPI = new HistoryAPI();
		ElevenLabs.modelsAPI = new ModelsAPI();
		ElevenLabs.projectsAPI = new ProjectsAPI();
		ElevenLabs.sampleAPI = new SampleAPI();
		ElevenLabs.speechToSpeechAPI = new SpeechToSpeechAPI();
		ElevenLabs.textToSpeechAPI = new TextToSpeechAPI();
		ElevenLabs.userAPI = new UserAPI();
		ElevenLabs.voiceAPI = new VoiceAPI();
		ElevenLabs.audioNativeAPI = new AudioNativeAPI();
	}

	public static AudioNativeAPI getAudioNativeAPI() {
		return audioNativeAPI;
	}

	public static HistoryAPI getHistoryAPI() {
		return historyAPI;
	}

	public static ModelsAPI getModelsAPI() {
		return modelsAPI;
	}

	public static ProjectsAPI getProjectsAPI() {
		return projectsAPI;
	}

	public static SampleAPI getSampleAPI() {
		return sampleAPI;
	}

	public static SpeechToSpeechAPI getSpeechToSpeechAPI() {
		return speechToSpeechAPI;
	}

	public static TextToSpeechAPI getTextToSpeechAPI() {
		return textToSpeechAPI;
	}

	public static UserAPI getUserAPI() {
		return userAPI;
	}

	public static VoiceAPI getVoiceAPI() {
		return voiceAPI;
	}
}
