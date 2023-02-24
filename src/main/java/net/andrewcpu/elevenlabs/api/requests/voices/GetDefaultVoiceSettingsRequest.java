package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.VoiceSettingTransformer;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

public class GetDefaultVoiceSettingsRequest extends ElevenLabsRequest<VoiceSettings> {
	public GetDefaultVoiceSettingsRequest() {
		super(HTTPMethod.GET, new VoiceSettingTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/settings/default";
	}
}
