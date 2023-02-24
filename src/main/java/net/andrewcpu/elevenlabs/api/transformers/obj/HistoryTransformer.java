package net.andrewcpu.elevenlabs.api.transformers.obj;

import net.andrewcpu.elevenlabs.api.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.elements.voice.History;
import org.json.simple.JSONObject;

public class HistoryTransformer extends ResultTransformerAdapter<History> {
	@Override
	public History transform(JSONObject object) {
		return History.fromJSON(object);
	}
}
