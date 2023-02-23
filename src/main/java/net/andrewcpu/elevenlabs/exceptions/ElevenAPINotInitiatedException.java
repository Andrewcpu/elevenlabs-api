package net.andrewcpu.elevenlabs.exceptions;

public class ElevenAPINotInitiatedException extends Exception{
	public ElevenAPINotInitiatedException() {
		super("ElevenLabs API has not been initiated.");
	}
}
