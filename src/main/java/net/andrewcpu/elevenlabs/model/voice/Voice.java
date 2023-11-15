package net.andrewcpu.elevenlabs.model.voice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.enums.GeneratedAudioOutputFormat;
import net.andrewcpu.elevenlabs.enums.StreamLatencyOptimization;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.tuning.FineTuning;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Voice extends ElevenModel {
	public static List<Voice> getVoices() {
		return ElevenLabs.getVoiceAPI().getVoices();
	}

	public static Voice getVoice(String voiceId) {
		return ElevenLabs.getVoiceAPI().getVoice(voiceId);
	}

	public static Voice getVoice(String voiceId, boolean withSettings) {
		return ElevenLabs.getVoiceAPI().getVoice(voiceId, withSettings);
	}

	@JsonProperty("voice_id")
	private String voiceId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("samples")
	private List<Sample> samples;

	@JsonProperty("category")
	private String category;

	@JsonProperty("fine_tuning")
	private FineTuning fineTuning;

	@JsonProperty("labels")
	private Map<String, String> labels;

	@JsonProperty("description")
	private String description;

	@JsonProperty("preview_url")
	private String previewUrl;

	@JsonProperty("available_for_tiers")
	private List<String> availableForTiers;

	@JsonProperty("settings")
	private VoiceSettings settings;

	@JsonProperty("sharing")
	private Sharing sharing;

	@JsonProperty("high_quality_base_model_ids")
	private List<String> highQualityBaseModelIds;

	@JsonIgnore
	public String getVoiceId() {
		return voiceId;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	@JsonIgnore
	public List<Sample> getSamples() {
		return samples.stream().peek(s -> s.voice = this).collect(Collectors.toList());
	}

	@JsonIgnore
	public String getCategory() {
		return category;
	}

	@JsonIgnore
	public FineTuning getFineTuning() {
		return fineTuning;
	}

	@JsonIgnore
	public Map<String, String> getLabels() {
		return labels;
	}

	@JsonIgnore
	public String getDescription() {
		return description;
	}

	@JsonIgnore
	public String getPreviewUrl() {
		return previewUrl;
	}

	@JsonIgnore
	public List<String> getAvailableForTiers() {
		return availableForTiers;
	}

	@JsonIgnore
	public VoiceSettings getSettings() {
		return settings;
	}

	@JsonIgnore
	public Sharing getSharing() {
		return sharing;
	}

	/**
	 * Warning! This will delete the voice.
	 */
	public String delete() {
		return ElevenLabs.getVoiceAPI().deleteVoice(voiceId);
	}
	public VoiceSettings fetchSettings() {
		this.settings = ElevenLabs.getVoiceAPI().getVoiceSettings(voiceId);
		return settings;
	}

	public VoiceSettings updateVoiceSettings(VoiceSettings voiceSettings) {
		ElevenLabs.getVoiceAPI().editVoiceSettings(voiceId, voiceSettings);
		this.settings = voiceSettings;
		return settings;
	}

	public Voice refresh() {
		Voice refreshedData = Voice.getVoice(voiceId, true);
		this.name = refreshedData.name;
		this.settings = refreshedData.settings;
		this.voiceId = refreshedData.voiceId;
		this.labels = refreshedData.labels;
		this.description = refreshedData.description;
		this.samples = refreshedData.samples;
		this.fineTuning = refreshedData.fineTuning;
		this.availableForTiers = refreshedData.availableForTiers;
		this.sharing = refreshedData.sharing;
		this.previewUrl = refreshedData.previewUrl;
		this.category = refreshedData.category;
		this.highQualityBaseModelIds = refreshedData.highQualityBaseModelIds;
		return this;
	}

	public File generate(String text, String model) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, model, settings);
	}

	public File generate(String text, String model, VoiceSettings settings) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, model, settings);
	}

	public File generate(String text, String model, VoiceSettings settings, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId,text, model, outputFormat,streamLatencyOptimization, settings);
	}
	public File generate(String text, String model, VoiceSettings settings, GeneratedAudioOutputFormat outputFormat) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId,text, model, outputFormat,StreamLatencyOptimization.getDefault(), settings);
	}
	public File generate(String text, VoiceSettings settings, GeneratedAudioOutputFormat outputFormat) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), outputFormat,StreamLatencyOptimization.getDefault(), settings);
	}
	public File generate(String text, VoiceSettings settings, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), GeneratedAudioOutputFormat.getDefault(),streamLatencyOptimization, settings);
	}

	public File generate(String text, VoiceSettings settings, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), outputFormat,streamLatencyOptimization, settings);
	}
	public File generate(String text, GeneratedAudioOutputFormat outputFormat, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), outputFormat,streamLatencyOptimization, settings);
	}
	public File generate(String text, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), GeneratedAudioOutputFormat.getDefault(), streamLatencyOptimization, settings);
	}

	public File generate(String text, VoiceSettings settings)  {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), settings);
	}

	public File generate(String text) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeech(voiceId, text, ElevenLabs.getDefaultModel(), settings);
	}



	public InputStream generateStream(String text, String model) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, model, settings);
	}

	public InputStream generateStream(String text, String model, VoiceSettings settings) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, model, settings);
	}

	public InputStream generateStream(String text, VoiceSettings settings)  {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, ElevenLabs.getDefaultModel(), settings);
	}

	public InputStream generateStream(String text) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, ElevenLabs.getDefaultModel(), settings);
	}

	public InputStream generateStream(String text, String model, GeneratedAudioOutputFormat generatedAudioOutputFormat, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, model, generatedAudioOutputFormat, streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text, String model,  GeneratedAudioOutputFormat generatedAudioOutputFormat, StreamLatencyOptimization streamLatencyOptimization, VoiceSettings settings) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, model, generatedAudioOutputFormat, streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text, VoiceSettings settings,  GeneratedAudioOutputFormat generatedAudioOutputFormat, StreamLatencyOptimization streamLatencyOptimization)  {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, ElevenLabs.getDefaultModel(), generatedAudioOutputFormat, streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text,  GeneratedAudioOutputFormat generatedAudioOutputFormat, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, ElevenLabs.getDefaultModel(), generatedAudioOutputFormat, streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text, String model, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, model, GeneratedAudioOutputFormat.getDefault(), streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text, String model, StreamLatencyOptimization streamLatencyOptimization, VoiceSettings settings) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, model, GeneratedAudioOutputFormat.getDefault(), streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text, VoiceSettings settings, StreamLatencyOptimization streamLatencyOptimization)  {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, ElevenLabs.getDefaultModel(), GeneratedAudioOutputFormat.getDefault(), streamLatencyOptimization, settings);
	}

	public InputStream generateStream(String text, StreamLatencyOptimization streamLatencyOptimization) {
		return ElevenLabs.getTextToSpeechAPI().generateTextToSpeechStreamed(voiceId, text, ElevenLabs.getDefaultModel(), GeneratedAudioOutputFormat.getDefault(), streamLatencyOptimization, settings);
	}

	public File speechToSpeech(File audioFile, StreamLatencyOptimization latencyOptimization, String modelId, VoiceSettings voiceSettings) {
		return ElevenLabs.getSpeechToSpeechAPI().generateSpeechToSpeech(voiceId, voiceSettings, modelId, audioFile, latencyOptimization);
	}

	public File speechToSpeech(File audioFile, StreamLatencyOptimization latencyOptimization, String modelId) {
		return speechToSpeech(audioFile, latencyOptimization, modelId, settings);
	}

	public File speechToSpeech(File audioFile, String modelId) {
		return speechToSpeech(audioFile, StreamLatencyOptimization.getDefault(), modelId,settings);
	}

	public InputStream speechToSpeechStream(File audioFile, StreamLatencyOptimization latencyOptimization, String modelId, VoiceSettings voiceSettings) {
		return ElevenLabs.getSpeechToSpeechAPI().generateSpeechToSpeechStream(voiceId, voiceSettings,modelId,audioFile,latencyOptimization);
	}

	public InputStream speechToSpeechStream(File audioFile, StreamLatencyOptimization latencyOptimization, String modelId) {
		return speechToSpeechStream(audioFile,latencyOptimization,modelId,settings);
	}

	public InputStream speechToSpeechStream(File audioFile, String modelId) {
		return speechToSpeechStream(audioFile, StreamLatencyOptimization.getDefault(),modelId);
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Voice{" +
				"voiceId='" + voiceId + '\'' +
				", name='" + name + '\'' +
				", samples=" + samples +
				", category='" + category + '\'' +
				", fineTuning=" + fineTuning +
				", labels=" + labels +
				", description='" + description + '\'' +
				", previewUrl='" + previewUrl + '\'' +
				", availableForTiers=" + availableForTiers +
				", settings=" + settings +
				", sharing=" + sharing +
				", highQualityBaseModelIds=" + highQualityBaseModelIds +
				'}';
	}
}
