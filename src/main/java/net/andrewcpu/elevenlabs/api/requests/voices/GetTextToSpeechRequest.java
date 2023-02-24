package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public class GetTextToSpeechRequest extends ElevenLabsRequest<File> {
	public GetTextToSpeechRequest(Voice voice, VoiceSettings settings, String text, File outputFile){
		super(List.of(voice.getVoiceId()), null, HTTPMethod.POST, new FilePingPongTransformer(outputFile));
		setBody(buildBody(settings, text));
		responseType = (ResponseType.FILE_STREAM);
		setOutputFilePath(outputFile);
	}

	private JSONObject buildBody(VoiceSettings settings, String text){
		JSONObject object = new JSONObject();
		object.put("text", text);
		object.put("voice_settings", settings.toJSON());
		return object;
	}

	@Override
	public String getEndpoint() {
		return "v1/text-to-speech/%s";
	}
}
