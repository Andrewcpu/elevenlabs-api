package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.ElevenLabsResponse;
import net.andrewcpu.elevenlabs.api.multipart.MultipartFile;
import net.andrewcpu.elevenlabs.api.multipart.MultipartFormContent;
import net.andrewcpu.elevenlabs.api.requests.history.DeleteHistoryItemRequest;
import net.andrewcpu.elevenlabs.api.requests.history.DownloadHistoryRequest;
import net.andrewcpu.elevenlabs.api.requests.history.GetHistoryAudioRequest;
import net.andrewcpu.elevenlabs.api.requests.history.GetHistoryRequest;
import net.andrewcpu.elevenlabs.api.requests.samples.DeleteSampleRequest;
import net.andrewcpu.elevenlabs.api.requests.samples.GetAudioSampleRequest;
import net.andrewcpu.elevenlabs.api.requests.user.GetSubscriptionInfoRequest;
import net.andrewcpu.elevenlabs.api.requests.user.GetUserRequest;
import net.andrewcpu.elevenlabs.api.requests.voices.*;
import net.andrewcpu.elevenlabs.api.requests.voices.settings.GetDefaultVoiceSettingsRequest;
import net.andrewcpu.elevenlabs.api.requests.voices.settings.GetVoiceSettingsRequest;
import net.andrewcpu.elevenlabs.api.requests.voices.settings.UpdateVoiceSettingsRequest;
import net.andrewcpu.elevenlabs.elements.user.Subscription;
import net.andrewcpu.elevenlabs.elements.user.User;
import net.andrewcpu.elevenlabs.elements.voice.History;
import net.andrewcpu.elevenlabs.elements.voice.Sample;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.enums.ContentType;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static net.andrewcpu.elevenlabs.util.MultipartUtil.addFilePart;
import static net.andrewcpu.elevenlabs.util.MultipartUtil.addFormField;

@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public class ElevenLabsAPI {
	//this class needs help
	private static ElevenLabsAPI instance;
	private static final String baseURL = "https://api.elevenlabs.io/v1/";
	private static boolean debugMode = false;

	public static boolean isDebugMode() {
		return debugMode;
	}

	public static void setDebugMode(boolean enabled){
		debugMode = enabled;
	}

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

	public Subscription getSubscription() throws ElevenLabsException {
		return (Subscription) getResult(new GetSubscriptionInfoRequest());
	}

	public User getUser() throws ElevenLabsException {
		return (User) getResult(new GetUserRequest());
	}

	public File getTextToSpeech(String text, Voice voice, VoiceSettings settings, File outputFile) throws ElevenLabsException {
		return (File)getResult(new GenerateTextToSpeechRequest(voice, settings, text, outputFile));
	}

	public List<Voice> getVoices() throws ElevenLabsException {
		return (List<Voice>) getResult(new GetVoicesRequest());
	}

	public Voice getVoice(String voiceId, boolean withSettings) throws ElevenLabsException {
		return (Voice)getResult(new GetVoiceRequest(voiceId, withSettings));
	}

	public Voice getVoice(String voiceId) throws ElevenLabsException {
		return getVoice(voiceId, true);
	}

	public VoiceSettings getVoiceSettings(String voiceId) throws ElevenLabsException {
		return (VoiceSettings) getResult(new GetVoiceSettingsRequest(voiceId));
	}

	public VoiceSettings getVoiceSettings(Voice voice) throws ElevenLabsException {
		return getVoiceSettings(voice.getVoiceId());
	}

	public String deleteVoice(Voice voice) throws ElevenLabsException {
		return deleteVoice(voice.getVoiceId());
	}

	public String deleteVoice(String voiceId) throws ElevenLabsException {
		return (String)getResult(new DeleteVoiceRequest(voiceId));
	}

	public String editVoice(Voice voice, VoiceSettings voiceSettings) throws ElevenLabsException {
		return editVoice(voice.getVoiceId(), voiceSettings);
	}

	public String editVoice(String voiceId, VoiceSettings settings) throws ElevenLabsException {
		return (String)getResult(new UpdateVoiceSettingsRequest(voiceId, settings));
	}


	public String deleteSample(String voiceId, String sampleId) throws ElevenLabsException {
		return (String)getResult(new DeleteSampleRequest(voiceId, sampleId));
	}

	public String deleteSample(Voice voice, String sampleId) throws ElevenLabsException {
		return deleteSample(voice.getVoiceId(), sampleId);
	}
	public String deleteSample(String voiceId, Sample sample) throws ElevenLabsException {
		return deleteSample(voiceId, sample.getSampleId());
	}

	public String deleteSample(Voice voice, Sample sample) throws ElevenLabsException {
		return deleteSample(voice.getVoiceId(), sample.getSampleId());
	}

	public File getSampleAudio(String voiceId, String sampleId, File file) throws ElevenLabsException {
		return (File)getResult(new GetAudioSampleRequest(voiceId, sampleId, file));
	}
	public File getSampleAudio(Voice voice, Sample sample, File file) throws ElevenLabsException {
		return getSampleAudio(voice.getVoiceId(), sample.getSampleId(), file);
	}

	public History getHistory() throws ElevenLabsException {
		return (History)getResult(new GetHistoryRequest());
	}

	public File downloadHistory(List<String> historyIds, File outputFile) throws ElevenLabsException {
		return (File)getResult(new DownloadHistoryRequest(historyIds, outputFile));
	}

	public File getHistoryItemAudio(History.HistoryItem historyItem, File outputFile) throws ElevenLabsException {
		return (File)getResult(new GetHistoryAudioRequest(historyItem.getHistoryItemId(), outputFile));
	}

	public String deleteHistoryItem(History.HistoryItem historyItem) throws ElevenLabsException {
		return (String)getResult(new DeleteHistoryItemRequest(historyItem.getHistoryItemId()));
	}

	public VoiceSettings getDefaultVoiceSettings() throws ElevenLabsException {
		return (VoiceSettings)getResult(new GetDefaultVoiceSettingsRequest());
	}

	public String createVoice(String name, Map<String, String> labels, List<File> files) throws ElevenLabsException {
		CreateVoiceRequest request = new CreateVoiceRequest(name, files, labels);
		return (String)(getResult(request));
	}

	@SuppressWarnings("UnusedReturnValue")
	public String editVoice(String voiceId, String name, Map<String, String> labels, List<File> files) throws ElevenLabsException {
		EditVoiceRequest editVoiceRequest = new EditVoiceRequest(voiceId,name,files,labels);
		return (String)(getResult(editVoiceRequest));
	}


	private void checkOrThrow(ElevenLabsResponse<?> response) throws ElevenLabsException {
		if(response == null){
			throw new ElevenLabsValidationException("An error has occurred.");
		}
		if(!response.isSuccessful()){
			throw response.getException();
		}
	}

	private Object getResult(ElevenLabsRequest<?> request) throws ElevenLabsException {
		ElevenLabsResponse<?> response = sendRequest(request);
		checkOrThrow(response);
		return response.getResult();
	}

	private ElevenLabsResponse<?> sendRequest(ElevenLabsRequest<?> request) throws ElevenLabsAPINotInitiatedException {
		if(!instantiated){
			throw new ElevenLabsAPINotInitiatedException();
		}
		String formattedEndpoint = request.getFormattedEndpoint();
		String boundary = "---------------------------" + System.currentTimeMillis();

		URL url = null;
		int responseCode = 999;
		InputStream successStream = null,
				errorStream = null;

		try {
			url = new URL(baseURL + formattedEndpoint);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			setupConnection(request, boundary, connection);

			if(request.getContentType() == ContentType.JSON){
				handleJSON(request, connection);
			}
			else if(request.getContentType() == ContentType.MULTIPART){
				handleMultipart(request, connection, boundary);
			}
			responseCode = connection.getResponseCode();
			if (responseCode >= 200 && responseCode < 300) {
				successStream = connection.getInputStream();
			} else {
				errorStream = connection.getErrorStream();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return new ElevenLabsResponse<>(responseCode, errorStream, successStream, request);
	}

	private void setupConnection(ElevenLabsRequest<?> request, String boundary, HttpURLConnection connection) throws ProtocolException {
		connection.setConnectTimeout(60000);
		connection.setReadTimeout(60000);
		connection.setRequestMethod(request.getMethod().name());
		String contType = request.getContentType().getType();
		if(request.getContentType() == ContentType.MULTIPART){
			contType += "; boundary=" + boundary;
		}
		connection.setRequestProperty("xi-api-key", apiKey);
		connection.setRequestProperty("Content-Type", contType); // this can be done better.
		connection.setDoOutput(true);
	}

	private static void handleJSON(ElevenLabsRequest<?> request, HttpURLConnection connection) throws IOException {
		if (request.getBody() != null) {
			connection.getOutputStream().write(request.getBody().toJSONString().getBytes(StandardCharsets.UTF_8));
		}
	}

	private static void handleMultipart(ElevenLabsRequest<?> request, HttpURLConnection connection, String boundary) throws IOException {
		for(MultipartFormContent item : request.getMultipartForm().getItems()){
			if(item instanceof MultipartFile multipartFile){
				addFilePart(multipartFile.getName(),multipartFile.getFilename(), multipartFile.getFile(), boundary, connection);
			}
			else{
				addFormField(item.getName(), item.getValue(), boundary, connection);
			}
		}
		String footer = "--" + boundary + "--\r\n";
		connection.getOutputStream().write(footer.getBytes(StandardCharsets.UTF_8));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
	}
}
