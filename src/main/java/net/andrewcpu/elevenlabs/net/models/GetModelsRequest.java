package net.andrewcpu.elevenlabs.net.models;

import net.andrewcpu.elevenlabs.model.response.GenerationTypeModel;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetModelsRequest extends GetRequest<GenerationTypeModel[]> {
	public GetModelsRequest() {
		super("v1/models", GenerationTypeModel[].class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
