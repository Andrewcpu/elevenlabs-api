package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.multipart.MultipartFile;
import net.andrewcpu.elevenlabs.api.multipart.MultipartForm;
import net.andrewcpu.elevenlabs.api.multipart.MultipartFormContent;
import net.andrewcpu.elevenlabs.api.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformer;
import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
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
		buildBody(name, files, labels);
	}
	public CreateVoiceRequest(List<String> parameters, String name, List<File> files, Map<String, String> labels) {
		super(parameters, RequestTransformer.VOICE_ID_TRANSFORMER);
		buildBody(name, files, labels);
	}

	@Override
	public String getEndpoint() {
		return "voices/add";
	}

	private void buildBody(String name, List<File> files, Map<String, String> labels){
		this.contentType = ContentType.MULTIPART;
		this.multipartForm = new MultipartForm();

		JSONObject val = new JSONObject();
		if(labels != null && labels.size() != 0){
			for(String key : labels.keySet()){
				val.put(key, labels.get(key));
			}
		}

		MultipartFormContent nameMultipart = new MultipartFormContent("name", URLEncoder.encode(name, StandardCharsets.UTF_8));
		MultipartFormContent labelsMultipart = new MultipartFormContent("labels", val.toJSONString());
		this.multipartForm.push(nameMultipart, labelsMultipart);

		for(File file : files){
			this.multipartForm.push(new MultipartFile("files", file));
		}
	}

}
