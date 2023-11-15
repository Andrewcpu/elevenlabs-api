package net.andrewcpu.elevenlabs.requests.sts;

import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PostSpeechToSpeechStreamedRequest extends PostRequest<InputStream> {
	private final StreamLatencyOptimization latencyOptimization;
	private final String modelId;
	private final VoiceSettings voiceSettings;
	private final File audio;
	public PostSpeechToSpeechStreamedRequest(String voiceId, VoiceSettings voiceSettings, File audio, String modelId, StreamLatencyOptimization latencyOptimization) {
		super("v1/speech-to-speech/" + voiceId + "/stream", InputStream.class);
		this.latencyOptimization = latencyOptimization;
		this.voiceSettings = voiceSettings;
		this.audio = audio;
		this.modelId = modelId;
	}

	@Override
	public Map<String, String> getQueryParameters() {
		Map<String, String> opts = new HashMap<>();
		opts.put("optimize_streaming_latency",String.valueOf(latencyOptimization.getValue()));
		return opts;
	}

	@Override
	public Object getPayload() {
		Map<String, Object> body = new HashMap<>();
		body.put("audio", audio);
		body.put("model_id", modelId);
		body.put("voice_settings", voiceSettings);
		return body;
	}
}
