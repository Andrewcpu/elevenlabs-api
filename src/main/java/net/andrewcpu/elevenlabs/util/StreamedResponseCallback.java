package net.andrewcpu.elevenlabs.util;

import java.io.InputStream;

public interface StreamedResponseCallback {
	public void handleStreamedResponse(InputStream inputStream, InputStream errorStream);
}
