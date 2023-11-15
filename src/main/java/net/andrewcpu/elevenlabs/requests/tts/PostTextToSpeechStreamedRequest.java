package net.andrewcpu.elevenlabs.requests.tts;

import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.request.TextToSpeechRequest;
import net.andrewcpu.elevenlabs.requests.PostRequest;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PostTextToSpeechStreamedRequest extends PostRequest<InputStream> {
	private TextToSpeechRequest request;
	private StreamLatencyOptimization streamLatencyOptimization;
	private GeneratedAudioOutputFormat outputFormat;

	public PostTextToSpeechStreamedRequest(String voiceId, TextToSpeechRequest request) {
		super("v1/text-to-speech/" + voiceId, InputStream.class);
		this.request = request;
		this.streamLatencyOptimization = StreamLatencyOptimization.getDefault();
		this.outputFormat = GeneratedAudioOutputFormat.getDefault();
	}

	public PostTextToSpeechStreamedRequest(String voiceId, TextToSpeechRequest request, StreamLatencyOptimization streamLatencyOptimization) {
		super("v1/text-to-speech/" + voiceId, InputStream.class);
		this.request = request;
		this.streamLatencyOptimization = streamLatencyOptimization;
		this.outputFormat = GeneratedAudioOutputFormat.getDefault();
	}

	public PostTextToSpeechStreamedRequest(String voiceId, TextToSpeechRequest request, StreamLatencyOptimization streamLatencyOptimization, GeneratedAudioOutputFormat generatedAudioOutputFormat) {
		super("v1/text-to-speech/" + voiceId, InputStream.class);
		this.request = request;
		this.streamLatencyOptimization = streamLatencyOptimization;
		this.outputFormat = generatedAudioOutputFormat;
	}

	public PostTextToSpeechStreamedRequest(String voiceId, TextToSpeechRequest request,  GeneratedAudioOutputFormat generatedAudioOutputFormat) {
		super("v1/text-to-speech/" + voiceId, InputStream.class);
		this.request = request;
		this.streamLatencyOptimization = StreamLatencyOptimization.getDefault();
		this.outputFormat = generatedAudioOutputFormat;
	}

	@Override
	public Map<String, String> getQueryParameters() {
		Map<String, String> map = new HashMap<>();
		map.put("optimize_streaming_latency", String.valueOf(streamLatencyOptimization.getValue()));
		map.put("output_format", outputFormat.name());
		return map;
	}

	@Override
	public Object getPayload() {
		return request;
	}
}
