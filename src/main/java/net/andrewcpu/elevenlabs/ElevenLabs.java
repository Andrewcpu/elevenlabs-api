package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.model.response.CreateVoiceResponse;
import net.andrewcpu.elevenlabs.model.response.GenerationTypeModel;
import net.andrewcpu.elevenlabs.model.user.Subscription;
import net.andrewcpu.elevenlabs.model.user.User;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.requests.history.*;
import net.andrewcpu.elevenlabs.requests.models.GetModelsRequest;
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

	public static String getApiKey() {
		return API_KEY;
	}

	public static void setApiKey(String apiKey) {
		API_KEY = apiKey;
	}

	private static <T> T sendRequest(ElevenLabsRequest<T> request) {
		return ElevenNetworkUtil.sendRequest(request.getType(),request.getEndpoint(), request.getPayload(),request.getResponseClass());
	}

	public static History getHistory() {
		return sendRequest(new GetHistoryRequest());
	}

	public static User getUser() {
		return sendRequest(new GetUserRequest());
	}

	public static Subscription getSubscription() {
		return sendRequest(new GetSubscriptionRequest());
	}

	public static HistoryItem getHistoryItem(String historyItemId) {
		return sendRequest(new GetHistoryItemByIdRequest(historyItemId));
	}

	public static String deleteHistoryItem(String historyItemId) {
		return sendRequest(new DeleteHistoryItemRequest(historyItemId));
	}

	public static File getHistoryItemAudio(String historyItemId) {
		return sendRequest(new GetHistoryItemAudioRequest(historyItemId));
	}

	public static File getHistoryItemAudio(String... historyItemIds) {
		return sendRequest(new PostDownloadHistoryItemsRequest(historyItemIds));
	}

	public static String deleteSample(String voiceId, String sampleId) {
		return sendRequest(new DeleteSampleRequest(voiceId, sampleId));
	}

	public static File getAudioSample(String voiceId, String sampleId) {
		return sendRequest(new GetSampleRequest(voiceId, sampleId));
	}

	public static List<Voice> getVoices() {
		return sendRequest(new GetVoicesRequest()).getVoices();
	}

	public static VoiceSettings getDefaultVoiceSettings() {
		return sendRequest(new GetDefaultVoiceSettingsRequest());
	}

	public static VoiceSettings getVoiceSettings(String voiceId) {
		return sendRequest(new GetVoiceSettingsRequest(voiceId));
	}

	public static Voice getVoice(String voiceId) {
		return sendRequest(new GetVoiceRequest(voiceId));
	}

	public static Voice getVoice(String voiceId, boolean withSettings) {
		return sendRequest(new GetVoiceRequest(voiceId, withSettings));
	}

	public static String deleteVoice(String voiceId) {
		return sendRequest(new DeleteVoiceRequest(voiceId));
	}

	public static String editVoiceSettings(String voiceId, VoiceSettings settings) {
		return sendRequest(new PostEditVoiceSettingsRequest(voiceId, settings));
	}

	public static CreateVoiceResponse createVoice(String name, File[] files, String description, Map<String, String> labels) {
		return sendRequest(new PostAddVoiceRequest(name, files, description, labels));
	}
	public static String editVoice(String voiceId, String name, File[] files, String description, Map<String, String> labels) {
		return sendRequest(new PostEditVoiceRequest(voiceId, name, files, description, labels));
	}

	public static GenerationTypeModel[] getAvailableModels() {
		return sendRequest(new GetModelsRequest());
	}

	public static File generateTextToSpeech(String voiceId, String text, String modelId, VoiceSettings voiceSettings) {
		return sendRequest(new PostTextToSpeechRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings)));
	}

	public static InputStream generateTextToSpeechStreamed(String voiceId, String text, String modelId, VoiceSettings voiceSettings) {
		return sendRequest(new PostTextToSpeechStreamedRequest(voiceId, new TextToSpeechRequest(text, modelId, voiceSettings)));
	}
}
