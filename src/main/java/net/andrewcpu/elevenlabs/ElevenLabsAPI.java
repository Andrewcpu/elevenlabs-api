package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.ElevenLabsResponse;
import net.andrewcpu.elevenlabs.api.requests.voices.GetTextToSpeechRequest;
import net.andrewcpu.elevenlabs.api.requests.history.DeleteHistoryItemRequest;
import net.andrewcpu.elevenlabs.api.requests.history.DownloadHistoryRequest;
import net.andrewcpu.elevenlabs.api.requests.history.GetHistoryAudioRequest;
import net.andrewcpu.elevenlabs.api.requests.history.GetHistoryRequest;
import net.andrewcpu.elevenlabs.api.requests.samples.DeleteSampleRequest;
import net.andrewcpu.elevenlabs.api.requests.samples.GetAudioSampleRequest;
import net.andrewcpu.elevenlabs.api.requests.user.GetSubscriptionInfoRequest;
import net.andrewcpu.elevenlabs.api.requests.user.GetUserRequest;
import net.andrewcpu.elevenlabs.api.requests.voices.*;
import net.andrewcpu.elevenlabs.elements.*;
import net.andrewcpu.elevenlabs.exceptions.ElevenAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ElevenLabsAPI {
	private static ElevenLabsAPI instance;
	private static final String baseURL = "https://api.elevenlabs.io/";

	public static ElevenLabsAPI getInstance() {
		if (instance == null) {
			instance = new ElevenLabsAPI();
		}
		return instance;
	}

	private boolean instantiated;
	private String apiKey;

	public ElevenLabsAPI() {
		instantiated = false;
	}

	public void setAPIKey(String apiKey) {
		instantiated = true;
		this.apiKey = apiKey;
	}

	public Subscription getSubscription() throws IOException, ElevenLabsValidationException{
		return (Subscription) getResult(new GetSubscriptionInfoRequest());
	}

	public User getUser() throws IOException, ElevenLabsValidationException{
		return (User) getResult(new GetUserRequest());
	}

	public File getTextToSpeech(String text, Voice voice, VoiceSettings settings, File outputFile) throws IOException, ElevenLabsValidationException {
		return (File)getResult(new GetTextToSpeechRequest(voice, settings, text, outputFile));
	}

	public List<Voice> getVoices() throws ElevenLabsValidationException, IOException {
		return (List<Voice>) getResult(new GetVoicesRequest());
	}

	public Voice getVoice(String voiceId, boolean withSettings) throws ElevenLabsValidationException, IOException{
		return (Voice)getResult(new GetVoiceRequest(voiceId, withSettings));
	}

	public Voice getVoice(String voiceId) throws ElevenLabsValidationException, IOException {
		return getVoice(voiceId, true);
	}

	public VoiceSettings getVoiceSettings(String voiceId) throws IOException, ElevenLabsValidationException {
		return (VoiceSettings) getResult(new GetVoiceSettingsRequest(voiceId));
	}

	public VoiceSettings getVoiceSettings(Voice voice) throws IOException, ElevenLabsValidationException {
		return getVoiceSettings(voice.getVoiceId());
	}

	public String deleteVoice(Voice voice) throws IOException, ElevenLabsValidationException {
		return deleteVoice(voice.getVoiceId());
	}

	public String deleteVoice(String voiceId) throws IOException, ElevenLabsValidationException {
		return (String)getResult(new DeleteVoiceRequest(voiceId));
	}

	public String editVoice(Voice voice, VoiceSettings voiceSettings) throws IOException, ElevenLabsValidationException {
		return editVoice(voice.getVoiceId(), voiceSettings);
	}

	public String editVoice(String voiceId, VoiceSettings settings) throws IOException, ElevenLabsValidationException {
		return (String)getResult(new UpdateVoiceSettingsRequest(voiceId, settings));
	}


	public String deleteSample(String voiceId, String sampleId) throws IOException, ElevenLabsValidationException{
		return (String)getResult(new DeleteSampleRequest(voiceId, sampleId));
	}

	public String deleteSample(Voice voice, String sampleId) throws IOException, ElevenLabsValidationException{
		return deleteSample(voice.getVoiceId(), sampleId);
	}
	public String deleteSample(String voiceId, Sample sample) throws IOException, ElevenLabsValidationException{
		return deleteSample(voiceId, sample.getSampleId());
	}

	public String deleteSample(Voice voice, Sample sample) throws IOException, ElevenLabsValidationException{
		return deleteSample(voice.getVoiceId(), sample.getSampleId());
	}

	public File getSampleAudio(String voiceId, String sampleId, File file) throws IOException, ElevenLabsValidationException {
		return (File)getResult(new GetAudioSampleRequest(voiceId, sampleId, file));
	}
	public File getSampleAudio(Voice voice, Sample sample, File file) throws IOException, ElevenLabsValidationException {
		return getSampleAudio(voice.getVoiceId(), sample.getSampleId(), file);
	}

	public History getHistory() throws IOException, ElevenLabsValidationException {
		return (History)getResult(new GetHistoryRequest());
	}

	public File downloadHistory(List<String> historyIds, File outputFile) throws IOException, ElevenLabsValidationException{
		return (File)getResult(new DownloadHistoryRequest(historyIds, outputFile));
	}

	public File getHistoryItemAudio(History.HistoryItem historyItem, File outputFile) throws IOException, ElevenLabsValidationException {
		return (File)getResult(new GetHistoryAudioRequest(historyItem.getHistoryItemId(), outputFile));
	}

	public String deleteHistoryItem(History.HistoryItem historyItem) throws IOException, ElevenLabsValidationException{
		return (String)getResult(new DeleteHistoryItemRequest(historyItem.getHistoryItemId()));
	}

	public VoiceSettings getDefaultVoiceSettings() throws IOException, ElevenLabsValidationException {
		return (VoiceSettings)getResult(new GetDefaultVoiceSettingsRequest());
	}


	private void checkOrThrow(ElevenLabsResponse<?> response) throws ElevenLabsValidationException {
		if(response == null){
			throw new ElevenLabsValidationException("An error has occurred.");
		}
		if(!response.isSuccessful()){
			throw response.getException();
		}
	}

	private Object getResult(ElevenLabsRequest<?> request) throws ElevenLabsValidationException, IOException {
		ElevenLabsResponse<?> response = sendRequest(request);
		checkOrThrow(response);
		return response.getResult();
	}

	private ElevenLabsResponse<?> sendRequest(ElevenLabsRequest<?> request) throws IOException {
		if(!instantiated){
			try{
				throw new ElevenAPINotInitiatedException();
			}catch (Exception e){
				e.printStackTrace();
				return null;
			}
		}
		String formattedEndpoint = request.getFormattedEndpoint();
		if(formattedEndpoint.startsWith("/")){
			formattedEndpoint = formattedEndpoint.substring(1);
		}
		URL url = new URL(baseURL + formattedEndpoint);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(request.getMethod().name());
		connection.setRequestProperty("xi-api-key", apiKey);
		if (request.getBody() != null) {
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.getOutputStream().write(request.getBody().toJSONString().getBytes(StandardCharsets.UTF_8));
		}

		int responseCode = connection.getResponseCode();
		InputStream successStream = null,
					errorStream = null;
		if (responseCode >= 200 && responseCode < 300) {
			successStream = connection.getInputStream();
		} else {
			errorStream = connection.getErrorStream();
		}
		return new ElevenLabsResponse<>(responseCode, errorStream, successStream,request);
	}
}
