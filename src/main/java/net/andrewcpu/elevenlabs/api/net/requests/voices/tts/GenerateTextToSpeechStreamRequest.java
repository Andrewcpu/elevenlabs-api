package net.andrewcpu.elevenlabs.api.net.requests.voices.tts;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestInputStreamTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import net.andrewcpu.elevenlabs.util.StreamedResponseCallback;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class GenerateTextToSpeechStreamRequest extends ElevenLabsPostRequest<InputStream> {

	private static JSONObject buildBody(VoiceSettings settings, String text){
		JSONObject object = new JSONObject();
		object.put("text", text);
		object.put("voice_settings", settings.toJSON());
		return object;
	}
	public GenerateTextToSpeechStreamRequest(Voice voice, VoiceSettings settings, String text, StreamedResponseCallback callback, File outputFile){
		super(List.of(voice.getVoiceId()), buildBody(settings, text), new RequestInputStreamTransformer());
		responseType = (ResponseType.FILE_STREAM);
		this.streamedResponseCallback = callback;
		this.outputFilePath = outputFile;
		if(outputFilePath.exists()) outputFilePath.delete();
	}

	@Override
	public String getEndpoint() {
		return "text-to-speech/{voiceId}/stream";
	}
}
