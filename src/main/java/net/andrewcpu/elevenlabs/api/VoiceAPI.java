package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.api.net.requests.voices.*;
import net.andrewcpu.elevenlabs.api.net.requests.voices.settings.GetDefaultVoiceSettingsRequest;
import net.andrewcpu.elevenlabs.api.net.requests.voices.settings.GetVoiceSettingsRequest;
import net.andrewcpu.elevenlabs.api.net.requests.voices.settings.UpdateVoiceSettingsRequest;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;
import java.util.Map;

import static net.andrewcpu.elevenlabs.ElevenLabsAPI.getRequestResult;

public class VoiceAPI {
	public static VoiceSettings getDefaultVoiceSettings() throws ElevenLabsException {
		return getRequestResult(new GetDefaultVoiceSettingsRequest());
	}

	public static File getTextToSpeech(String text, Voice voice, VoiceSettings settings, File outputFile) throws ElevenLabsException {
		return getRequestResult(new GenerateTextToSpeechRequest(voice, settings, text, outputFile));
	}

	public static List<Voice> getVoices() throws ElevenLabsException {
		return getRequestResult(new GetVoicesRequest());
	}

	public static Voice getVoice(String voiceId, boolean withSettings) throws ElevenLabsException {
		return getRequestResult(new GetVoiceRequest(voiceId, withSettings));
	}

	public static Voice getVoice(String voiceId) throws ElevenLabsException {
		return getVoice(voiceId, true);
	}

	public static VoiceSettings getVoiceSettings(String voiceId) throws ElevenLabsException {
		return getRequestResult(new GetVoiceSettingsRequest(voiceId));
	}

	public static VoiceSettings getVoiceSettings(Voice voice) throws ElevenLabsException {
		return getVoiceSettings(voice.getVoiceId());
	}

	public static boolean deleteVoice(Voice voice) throws ElevenLabsException {
		return deleteVoice(voice.getVoiceId());
	}

	public static boolean deleteVoice(String voiceId) throws ElevenLabsException {
		JSONObject result = getRequestResult(new DeleteVoiceRequest(voiceId));
		if(result.containsKey("status") && result.get("status").equals("ok")){
			return true;
		}
		return false;
	}

	public static JSONObject editVoice(Voice voice, VoiceSettings voiceSettings) throws ElevenLabsException {
		return editVoice(voice.getVoiceId(), voiceSettings);
	}

	public static JSONObject editVoice(String voiceId, VoiceSettings settings) throws ElevenLabsException {
		return getRequestResult(new UpdateVoiceSettingsRequest(voiceId, settings));
	}

	public static String createVoice(String name, Map<String, String> labels, List<File> files) throws ElevenLabsException {
		CreateVoiceRequest request = new CreateVoiceRequest(name, files, labels);
		return getRequestResult(request);
	}

	public static JSONObject editVoice(String voiceId, String name, Map<String, String> labels, List<File> files) throws ElevenLabsException {
		EditVoiceRequest editVoiceRequest = new EditVoiceRequest(voiceId, name, files, labels);
		return getRequestResult(editVoiceRequest);
	}

}
