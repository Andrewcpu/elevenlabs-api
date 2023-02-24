package net.andrewcpu.elevenlabs.util;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;

public class DebugLogger {
	public static void log(Class<?> className, String message){
		if(ElevenLabsAPI.isDebugMode()){
			System.out.println(className.getSimpleName() + ": " + message);
		}
	}
}
