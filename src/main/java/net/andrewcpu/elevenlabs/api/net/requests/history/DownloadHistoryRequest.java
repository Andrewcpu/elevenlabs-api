package net.andrewcpu.elevenlabs.api.net.requests.history;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

@SuppressWarnings("unchecked")
public class DownloadHistoryRequest extends ElevenLabsPostRequest<File> {
	private static JSONObject getBody(List<String> historyIds) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		array.addAll(historyIds);
		object.put("history_item_ids", array);
		return object;
	}
	public DownloadHistoryRequest(List<String> historyIds, File outputFile) {
		super(null, getBody(historyIds), new FilePingPongTransformer(outputFile));
		responseType = (ResponseType.FILE_STREAM);
		outputFilePath = (outputFile);
	}

	@Override
	public String getEndpoint() {
		return "history/download";
	}
}
