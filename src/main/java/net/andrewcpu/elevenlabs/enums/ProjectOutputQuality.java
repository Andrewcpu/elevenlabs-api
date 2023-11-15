package net.andrewcpu.elevenlabs.enums;

public enum ProjectOutputQuality {
	STANDARD,
	HIGH,
	ULTRA;

	public static ProjectOutputQuality getDefault() {
		return STANDARD;
	}
}
