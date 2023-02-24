package net.andrewcpu.elevenlabs.enums;

public enum ContentType {
	JSON("application/json"), MULTIPART("multipart/form-data");
	private final String type;

	ContentType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
