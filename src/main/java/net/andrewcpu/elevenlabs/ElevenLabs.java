package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.api.impl.*;

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
