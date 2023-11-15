package net.andrewcpu.elevenlabs.User;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest extends ElevenLabsTest {
	@Test
	public void testGetUser() {
		try{
			ElevenLabs.getUserAPI().getUser();
		}catch (Exception e) {
			e.printStackTrace();
			assertTrue("Failed to get user: " + e.getMessage(), false);
		}
	}

	@Test
	public void testGetSubscription() {
		try{
			ElevenLabs.getUserAPI().getSubscription();
		}catch (Exception e) {
			e.printStackTrace();
			assertFalse("Failed to get subscription: " + e.getMessage(), true);
		}
	}
}
