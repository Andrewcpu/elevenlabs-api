package net.andrewcpu.elevenlabs.Sample;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import net.andrewcpu.elevenlabs.model.voice.Sample;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class AudioSampleTest extends ElevenLabsTest {
	@Test
	public void testGetAudioSamples() {
		assertFalse("Couldn't load audio samples.", doesThrow(() -> {
			List<Sample> samples = null;
			samples = ElevenLabs.getVoiceAPI().getVoice(TEST_VOICE, true).getSamples();
			assertNotNull(samples);
		}));
	}
	@Test
	public void testGetAudioSample() {
		assertFalse("Couldn't load audio sample.", doesThrow(() -> {
			Voice voice = ElevenLabs.getVoiceAPI().getVoice(TEST_VOICE, true);
			assertNotNull("Voice is null!", voice);
			assertNotNull("Voice samples are null!", voice.getSamples());
			assertTrue("No samples to test!", voice.getSamples().size() != 0);
			File file = ElevenLabs.getSampleAPI().getAudioSample(TEST_VOICE, voice.getSamples().get(0).getSampleId());
			assertNotNull(file);
			file.delete();
		}));
	}
}
