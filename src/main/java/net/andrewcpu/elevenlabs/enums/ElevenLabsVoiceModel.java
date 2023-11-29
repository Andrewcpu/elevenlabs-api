package net.andrewcpu.elevenlabs.enums;

public enum ElevenLabsVoiceModel {
	ELEVEN_MULTILINGUAL_V2("eleven_multilingual_v2", "Eleven Multilingual v2"),
	ELEVEN_ENGLISH_V2("eleven_english_v2", "Eleven English v2"),
	ELEVEN_MULTILINGUAL_V1("eleven_multilingual_v1", "Eleven Multilingual v1"),
	ELEVEN_MONOLINGUAL_V1("eleven_monolingual_v1", "Eleven English v1"),
	ELEVEN_TURBO_V2("eleven_turbo_v2", "Eleven Turbo v2"),
	ELEVEN_ENGLISH_STS_V2("eleven_english_sts_v2", "Eleven English v2", true),
	;
	final String modelId;
	final String modelLabel;
	final boolean supportsSpeechToSpeech;

	ElevenLabsVoiceModel(String modelId, String modelLabel, boolean supportsSpeechToSpeech) {
		this.modelId = modelId;
		this.modelLabel = modelLabel;
		this.supportsSpeechToSpeech = supportsSpeechToSpeech;
	}

	ElevenLabsVoiceModel(String modelId, String modelLabel) {
		this(modelId, modelLabel, false);
	}

	public String getModelId() {
		return modelId;
	}

	public String getModelLabel() {
		return modelLabel;
	}
}
