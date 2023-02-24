package net.andrewcpu.elevenlabs.exceptions;

public class ElevenLabsAPINotInitiatedException extends Exception{
	public ElevenLabsAPINotInitiatedException() {
		super("ElevenLabs API has not been initiated.");
	}
}
