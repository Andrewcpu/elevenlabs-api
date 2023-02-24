package net.andrewcpu.elevenlabs.elements;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedReturnValue")
public class VoiceBuilder {
	private String name = null;
	private final Map<String, String> labels;
	private final List<File> files;
	private String voiceId;

	public static VoiceBuilder fromVoice(Voice voice){
		VoiceBuilder voiceBuilder = new VoiceBuilder();
		voiceBuilder.withName(voice.getName());
		voiceBuilder.withVoiceID(voice.getVoiceId());
		for(String key : voice.getLabels().keySet()){
			voiceBuilder.withLabel(key, voice.getLabels().get(key));
		}
		return voiceBuilder;
	}

	public VoiceBuilder() {
		labels = new HashMap<>();
		files = new ArrayList<>();
		voiceId = null;
	}

	public VoiceBuilder withName(String name){
		this.name = name;
		return this;
	}

	public VoiceBuilder withFile(File file){
		files.add(file);
		return this;
	}

	public VoiceBuilder withLabel(String key, String value){
		labels.put(key, value);
		return this;
	}

	public VoiceBuilder removeLabel(String key){
		labels.remove(key);
		return this;
	}

	public VoiceBuilder removeFile(File file){
		files.remove(file);
		return this;
	}

	public VoiceBuilder withVoiceID(String id){
		this.voiceId = id;
		return this;
	}

	public Voice edit() throws IOException, ElevenLabsValidationException, ElevenLabsAPINotInitiatedException {
		ElevenLabsAPI.getInstance().editVoice(voiceId, name, labels, files);
		return ElevenLabsAPI.getInstance().getVoice(voiceId, true);
	}

	public Voice create() throws IOException, ElevenLabsValidationException, ElevenLabsAPINotInitiatedException {
		if(files.isEmpty()){
			throw new ElevenLabsValidationException("Cannot build a voice without any files.");
		}
		String voiceId = ElevenLabsAPI.getInstance().createVoice(name, labels, files);
		return ElevenLabsAPI.getInstance().getVoice(voiceId, true);
	}
}
