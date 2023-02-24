package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.requests.ResultTransformer;
import net.andrewcpu.elevenlabs.api.requests.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.api.requests.multipart.MultipartFile;
import net.andrewcpu.elevenlabs.api.requests.multipart.MultipartForm;
import net.andrewcpu.elevenlabs.api.requests.multipart.MultipartFormContent;
import net.andrewcpu.elevenlabs.enums.ContentType;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.util.MapUtil;
import org.json.simple.JSONObject;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class CreateVoiceRequest extends ElevenLabsRequest<String> {
	public CreateVoiceRequest(String name, List<File> files, Map<String, String> labels) {
		super(null, null, HTTPMethod.POST, new ResultTransformerAdapter<String>(){
			@Override
			public String transform(JSONObject object) {
				return object.get("voice_id").toString();
			}
		});
		contentType = ContentType.MULTIPART;
		setFiles(files);
		MultipartForm form = new MultipartForm();
		form.push(new MultipartFormContent("name", null, URLEncoder.encode(name, StandardCharsets.UTF_8), null));
		JSONObject val = new JSONObject();
		if(labels != null && labels.size() != 0){
			for(String key : labels.keySet()){
				val.put(key, labels.get(key));
			}
		}
		form.push(new MultipartFormContent("labels", null, val.toJSONString(), null));
		for(File file : files){
			form.push(new MultipartFile("files", file));
		}
		this.multipartForm = form;
	}
	public CreateVoiceRequest(List<String> parameters, String name, List<File> files, Map<String, String> labels) {
		super(parameters, null, HTTPMethod.POST, new ResultTransformerAdapter<String>(){
			@Override
			public String transform(JSONObject object) {
				return object.get("voice_id").toString();
			}
		});
		contentType = ContentType.MULTIPART;
		setFiles(files);
		MultipartForm form = new MultipartForm();
		form.push(new MultipartFormContent("name", null, URLEncoder.encode(name, StandardCharsets.UTF_8), null));
		form.push(new MultipartFormContent("labels", null, MapUtil.encode(labels), null));
		for(File file : files){
			form.push(new MultipartFile("files", file));
		}
		this.multipartForm = form;
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/add";
	}
}
