package net.andrewcpu.elevenlabs.requests.projects;

import net.andrewcpu.elevenlabs.model.request.AddProjectRequest;
import net.andrewcpu.elevenlabs.model.response.ProjectModelResponse;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.util.HashMap;
import java.util.Map;

public class PostAddProjectRequest extends PostRequest<ProjectModelResponse> {
	private AddProjectRequest request;
	public PostAddProjectRequest(AddProjectRequest request) {
		super("v1/projects/add", ProjectModelResponse.class);
		this.request = request;
	}

	@Override
	public Object getPayload() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name",request.getName());
		payload.put("from_url", request.getFromUrl());
		payload.put("from_document", request.getFromDocument());
		payload.put("default_title_voice_id", request.getDefaultTitleVoiceId());
		payload.put("default_paragraph_voice_id", request.getDefaultParagraphVoiceId());
		payload.put("default_model_id", request.getDefaultModelId());
		payload.put("quality_preset", request.getProjectOutputQuality().name().toLowerCase());
		payload.put("title", request.getTitle());
		payload.put("author", request.getAuthor());
		payload.put("isbn_number", request.getIsbnNumber());
		payload.put("acx_volume_normalization", request.isAcxVolumeNormalization());
		return payload;
	}
}
