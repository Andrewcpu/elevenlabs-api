package net.andrewcpu.elevenlabs.User;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest extends ElevenLabsTest {
	@Test
	public void testGetUser() {
		try{
			ElevenLabs.getUserAPI().getUser();
		}catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get user: " + e.getMessage());
		}
	}

	@Test
	public void testGetSubscription() {
		try{
			ElevenLabs.getUserAPI().getSubscription();
		}catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get subscription: " + e.getMessage());
		}
	}
}
