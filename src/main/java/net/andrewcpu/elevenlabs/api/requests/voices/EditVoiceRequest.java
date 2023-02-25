package net.andrewcpu.elevenlabs.api.requests.voices;

import java.io.File;
import java.util.List;
import java.util.Map;

public class EditVoiceRequest extends CreateVoiceRequest{
	public EditVoiceRequest(String voiceId, String name, List<File> files, Map<String, String> labels) {
		super(List.of(voiceId), name, files, labels);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/edit";
	}
}
