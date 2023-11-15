package net.andrewcpu.elevenlabs.requests.audionative;

import net.andrewcpu.elevenlabs.model.request.CreateAudioNativeProjectRequest;
import net.andrewcpu.elevenlabs.model.response.CreateAudioEnabledProjectModelResponse;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.util.HashMap;
import java.util.Map;

public class PostCreateAudioNativeProjectRequest extends PostRequest<CreateAudioEnabledProjectModelResponse> {
	private final CreateAudioNativeProjectRequest request;
	public PostCreateAudioNativeProjectRequest(CreateAudioNativeProjectRequest request) {
		super("v1/audio-native", CreateAudioEnabledProjectModelResponse.class);
		this.request = request;
	}

	@Override
	public Object getPayload() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", request.getName());
		payload.put("image", request.getImage());
		payload.put("author", request.getAuthor());
		payload.put("small", request.isSmall());
		payload.put("text_color", request.getTextColor());
		payload.put("background_color", request.getBackgroundColor());
		payload.put("sessionization", request.getSessionization());
		payload.put("voice_id", request.getVoiceId());
		payload.put("model_id", request.getModelId());
		payload.put("file", request.getFile());
		payload.put("auto_convert", request.isAutoConvert());
		return payload;
	}
}
