package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.api.net.requests.samples.DeleteSampleRequest;
import net.andrewcpu.elevenlabs.api.net.requests.samples.GetAudioSampleRequest;
import net.andrewcpu.elevenlabs.elements.voice.Sample;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import org.json.simple.JSONObject;

import java.io.File;

import static net.andrewcpu.elevenlabs.ElevenLabsAPI.getRequestResult;

public class SampleAPI {
	public static JSONObject deleteSample(String voiceId, String sampleId) throws ElevenLabsException {
		return getRequestResult(new DeleteSampleRequest(voiceId, sampleId));
	}

	public static JSONObject deleteSample(Voice voice, String sampleId) throws ElevenLabsException {
		return deleteSample(voice.getVoiceId(), sampleId);
	}
	public static JSONObject deleteSample(String voiceId, Sample sample) throws ElevenLabsException {
		return deleteSample(voiceId, sample.getSampleId());
	}

	public static JSONObject deleteSample(Voice voice, Sample sample) throws ElevenLabsException {
		return deleteSample(voice.getVoiceId(), sample.getSampleId());
	}

	public static File getSampleAudio(String voiceId, String sampleId, File file) throws ElevenLabsException {
		return getRequestResult(new GetAudioSampleRequest(voiceId, sampleId, file));
	}
	public static File getSampleAudio(Voice voice, Sample sample, File file) throws ElevenLabsException {
		return getSampleAudio(voice.getVoiceId(), sample.getSampleId(), file);
	}
}
