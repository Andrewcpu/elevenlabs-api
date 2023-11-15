package net.andrewcpu.elevenlabs.enums;

public enum GeneratedAudioOutputFormat {
	MP3_44100_64,
	MP3_44100_96,
	MP3_44100_128,
	MP3_44100_192,
	PCM_16000,
	PCM_22050,
	PCM_24000,
	PCM_44100,
	ULAW_8000;


	// Method to get the default value
	public static GeneratedAudioOutputFormat getDefault() {
		return MP3_44100_128;
	}
}
