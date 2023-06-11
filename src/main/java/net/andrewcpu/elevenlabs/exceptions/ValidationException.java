package net.andrewcpu.elevenlabs.exceptions;

import net.andrewcpu.elevenlabs.model.error.ValidationError;

public class ValidationException extends RequestException{
	public ValidationException(ValidationError validationError) {
		super(validationError.toString());
	}
}
