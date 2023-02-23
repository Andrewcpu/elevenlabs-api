package net.andrewcpu.elevenlabs;

import net.andrewcpu.elevenlabs.elements.User;
import net.andrewcpu.elevenlabs.elements.Voice;
import net.andrewcpu.elevenlabs.elements.VoiceSettings;

import java.io.File;
import java.util.List;

public class Main {
	//api key
	public static void main(String[] args) throws Exception{
		ElevenLabsAPI.getInstance().setAPIKey("092a02471f488954fd5dd1cbf2cc355e");
		List<Voice> voices = Voice.getVoices();
		for(Voice voice : voices){
			System.out.println(voice.getVoiceId() + ", " + voice.getName());
//			if(voice.getName().startsWith("Roga")){
//				voice.generate("Hey. This is joe rogan, coming at you live.", new VoiceSettings(0.5, 0.5), new File("rogan.mp3"));
//			}
		}
		System.out.println(User.getUser().toString());

	}
}
