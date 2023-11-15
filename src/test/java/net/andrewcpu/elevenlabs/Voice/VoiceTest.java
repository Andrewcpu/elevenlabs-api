package net.andrewcpu.elevenlabs.Voice;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import net.andrewcpu.elevenlabs.model.voice.Voice;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class VoiceTest extends ElevenLabsTest {
	@Test
	public void testGetVoiceWithSettings() {
		Voice voice = null;
		try{
			voice = ElevenLabs.getVoiceAPI().getVoice(ElevenLabsTest.TEST_VOICE, true);
		}catch (Exception e){
			e.printStackTrace();
			assertNotNull("Failed to get voice: " + e.getMessage(), voice);
		}
		assertNotNull(voice.getSettings());
	}

	@Test
	public void testGetVoiceWithoutSettings() {
		Voice voice = null;
		try{
			voice = ElevenLabs.getVoiceAPI().getVoice(ElevenLabsTest.TEST_VOICE, false);
		}catch (Exception e){
			e.printStackTrace();
			assertNotNull("Failed to get voice: " + e.getMessage(), voice);
		}
		assertNull(voice.getSettings());
	}

	@Test
	public void testGetVoiceSettings() {
		VoiceSettings settings = null;
		try{
			settings = ElevenLabs.getVoiceAPI().getVoiceSettings(ElevenLabsTest.TEST_VOICE);
		}catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get voice settings: " + e.getMessage());
		}
	}

	@Test
	public void getDefaultVoiceSettings() {
		VoiceSettings defaultVoiceSettings = null;
		try {
			defaultVoiceSettings = ElevenLabs.getVoiceAPI().getDefaultVoiceSettings();
		}catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get default voice settings: " + e.getMessage());
		}
	}

	@Test
	public void getVoices() {
		List<Voice> voices = null;
		try{
			voices = ElevenLabs.getVoiceAPI().getVoices();
		}catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get voices: " + e.getMessage());
		}
		assertTrue(voices != null && voices.size() > 0);
	}
}
