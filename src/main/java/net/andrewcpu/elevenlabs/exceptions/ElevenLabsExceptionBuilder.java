package net.andrewcpu.elevenlabs.exceptions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ElevenLabsExceptionBuilder {
	public static ElevenLabsValidationException build(JSONObject errorResponse) {
		StringBuilder message = new StringBuilder();
		if(errorResponse.get("detail") instanceof JSONObject detail) {
			message.append(detail.get("status")).append(" ").append(detail.get("message"));
		}
		else if(errorResponse.get("detail") instanceof JSONArray details){
			for(Object detailObject : details){
				JSONObject detail = (JSONObject)detailObject;
				String locStr = ((JSONArray)detail.get("loc")).get(0).toString();
				int locInt = (int)(((JSONArray)detail.get("loc")).get(1));
				message.append(detail.get("type").toString())
						.append(": ")
						.append(detail.get("msg").toString()).append(" at ").append(locStr).append(":").append(locInt)
						.append("\n");
			}
		}

		return new ElevenLabsValidationException(message.toString().trim());
	}
}
