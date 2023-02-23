package net.andrewcpu.elevenlabs.exceptions;

import org.json.simple.JSONObject;

public class ElevenLabsValidationException extends Exception{
	public ElevenLabsValidationException(String message) {
		super(message);
	}
}
