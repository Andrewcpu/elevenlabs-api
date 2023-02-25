package net.andrewcpu.elevenlabs.exceptions;

public class ElevenLabsAPINotInitiatedException extends ElevenLabsException{
	public ElevenLabsAPINotInitiatedException() {
		super("ElevenLabs API has not been initiated.");
	}
}
