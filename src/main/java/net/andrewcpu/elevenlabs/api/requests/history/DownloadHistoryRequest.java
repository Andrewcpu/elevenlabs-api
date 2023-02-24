package net.andrewcpu.elevenlabs.api.requests.history;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public class DownloadHistoryRequest extends ElevenLabsRequest<File> {
	private static JSONObject getBody(List<String> historyIds) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		array.addAll(historyIds);
		object.put("history_item_ids", array);
		return object;
	}
	public DownloadHistoryRequest(List<String> historyIds, File outputFile) {
		super(null, getBody(historyIds), HTTPMethod.POST, new FilePingPongTransformer(outputFile));
		responseType = (ResponseType.FILE_STREAM);
		setOutputFilePath(outputFile);
	}

	@Override
	public String getEndpoint() {
		return "v1/history/download";
	}
}
