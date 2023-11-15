package net.andrewcpu.elevenlabs.api.impl;

import net.andrewcpu.elevenlabs.api.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.model.response.GenerationTypeModel;
import net.andrewcpu.elevenlabs.requests.models.GetModelsRequest;

public class ModelsAPI extends ElevenLabsAPI {

	public GenerationTypeModel[] getAvailableModels() {
		return sendRequest(new GetModelsRequest());
	}
}
