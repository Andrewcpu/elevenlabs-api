package net.andrewcpu.elevenlabs.api.net.requests.voices;

import net.andrewcpu.elevenlabs.api.net.multipart.MultipartFile;
import net.andrewcpu.elevenlabs.api.net.multipart.MultipartForm;
import net.andrewcpu.elevenlabs.api.net.multipart.MultipartFormContent;
import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.enums.ContentType;
import org.json.simple.JSONObject;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CreateVoiceRequest extends ElevenLabsPostRequest<String> {
	public CreateVoiceRequest(String name, List<File> files, Map<String, String> labels) {
		super(RequestTransformer.VOICE_ID_TRANSFORMER);
		this.contentType = ContentType.MULTIPART;
		this.multipartForm = new MultipartForm();
		buildBody(name, files, labels);
	}

	@Override
	public String getEndpoint() {
		return "voices/add";
	}

	private void buildBody(String name, List<File> files, Map<String, String> labels) {
		JSONObject val = new JSONObject();
		if (labels != null && labels.size() != 0) {
			labels.keySet().forEach(key -> val.put(key, labels.get(key)));
		}
		MultipartFormContent nameMultipart = new MultipartFormContent("name", URLEncoder.encode(name, StandardCharsets.UTF_8));
		MultipartFormContent labelsMultipart = new MultipartFormContent("labels", val.toJSONString());
		this.multipartForm.push(nameMultipart, labelsMultipart);
		this.multipartForm.push(files.stream()
				.map(file -> new MultipartFile("files", file))
				.toArray(MultipartFile[]::new));
	}
}
