package net.andrewcpu.elevenlabs.Models;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import net.andrewcpu.elevenlabs.model.response.GenerationTypeModel;
import org.junit.Test;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AvailableModelsTest extends ElevenLabsTest {
	@Test
	public void testGetModels() {
		GenerationTypeModel[] models = null;
		try{
			models = ElevenLabs.getModelsAPI().getAvailableModels();
			Arrays.stream(models).map(o -> o.getModelId() + "," + o.getName()).forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get voice type models: " + e.getMessage());
		}
	}
}
