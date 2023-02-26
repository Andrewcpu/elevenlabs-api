package net.andrewcpu.elevenlabs.exceptions;

import java.io.IOException;

public class ElevenLabsException extends Exception{
	public ElevenLabsException(String message) {
		super(message);
	}

	public ElevenLabsException(IOException ioException) {
		super(ioException);
	}
}
