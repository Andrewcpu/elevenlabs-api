package net.andrewcpu.elevenlabs.requests.tts;

import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PostTextToSpeechRequest extends PostRequest<File> {
	private final TextToSpeechRequest request;
	private final StreamLatencyOptimization streamLatencyOptimization;
	private final GeneratedAudioOutputFormat outputFormat;

	public PostTextToSpeechRequest(String voiceId, TextToSpeechRequest request) {
		super("v1/text-to-speech/" + voiceId, File.class);
		this.request = request;
		this.streamLatencyOptimization = StreamLatencyOptimization.getDefault();
		this.outputFormat = GeneratedAudioOutputFormat.getDefault();
	}

	public PostTextToSpeechRequest(String voiceId, TextToSpeechRequest request, StreamLatencyOptimization streamLatencyOptimization) {
		super("v1/text-to-speech/" + voiceId, File.class);
		this.request = request;
		this.streamLatencyOptimization = streamLatencyOptimization;
		this.outputFormat = GeneratedAudioOutputFormat.getDefault();
	}

	public PostTextToSpeechRequest(String voiceId, TextToSpeechRequest request, StreamLatencyOptimization streamLatencyOptimization, GeneratedAudioOutputFormat generatedAudioOutputFormat) {
		super("v1/text-to-speech/" + voiceId, File.class);
		this.request = request;
		this.streamLatencyOptimization = streamLatencyOptimization;
		this.outputFormat = generatedAudioOutputFormat;
	}

	public PostTextToSpeechRequest(String voiceId, TextToSpeechRequest request,  GeneratedAudioOutputFormat generatedAudioOutputFormat) {
		super("v1/text-to-speech/" + voiceId, File.class);
		this.request = request;
		this.streamLatencyOptimization = StreamLatencyOptimization.getDefault();
		this.outputFormat = generatedAudioOutputFormat;
	}


	@Override
	public Object getPayload() {
		return request;
	}

	@Override
	public Map<String, String> getQueryParameters() {
		Map<String, String> map = new HashMap<>();
		map.put("optimize_streaming_latency", String.valueOf(streamLatencyOptimization.getValue()));
		map.put("output_format", outputFormat.name());
		return map;
	}
}
