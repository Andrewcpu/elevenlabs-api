package net.andrewcpu.elevenlabs.TextToSpeech;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class TextToSpeechTest extends ElevenLabsTest {
	@Test
	public void testDownloadResponse() {
		assertFalse("Cannot download tts!", doesThrow(() -> {
			File file = ElevenLabs.generateTextToSpeech(TEST_VOICE, "This is a test", "eleven_monolingual_v1", new VoiceSettings(0.7, 0.7));
			file.delete();
		}));
	}

	@Test
	public void testStreamedResponse() {
		assertFalse("Cannot strem tts!", doesThrow(() -> {
			InputStream inputStream = ElevenLabs.generateTextToSpeechStreamed(TEST_VOICE, "This is a test", "eleven_monolingual_v1", new VoiceSettings(0.7, 0.7));
			File tmp;
			try {
				tmp = File.createTempFile("test", "audio");
				try (OutputStream outputStream = new FileOutputStream(tmp)) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					//read from is to buffer
					while((bytesRead = inputStream.read(buffer)) !=-1){
						outputStream.write(buffer, 0, bytesRead);
					}
					inputStream.close();
					//flush OutputStream to write any buffered data to file
					outputStream.flush();
				}
				if(tmp == null || tmp.length() == 0) {
					fail("Failed to stream object.");
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}));
	}
}
