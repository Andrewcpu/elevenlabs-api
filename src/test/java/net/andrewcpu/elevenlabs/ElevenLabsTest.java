package net.andrewcpu.elevenlabs;


public class ElevenLabsTest {
	public static final String ELEVEN_LABS_API_KEY = "";
	public static final String TEST_VOICE = "ZjJOFdM86g4E9U6OhzUo";
	static {
		ElevenLabs.setApiKey(ELEVEN_LABS_API_KEY);
	}

	/**
	 * deleteHistoryItem - WONT TEST
	 * deleteSample - WONT TEST
	 * deleteVoice - WONT TEST
	 * editVoiceSettings - WONT TEST
	 * createVoice - WONT TEST
	 * editVoice - WONT TEST
	 **/

	public boolean doesThrow(Runnable runnable) {
		try{
			runnable.run();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
}
