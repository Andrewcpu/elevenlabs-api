package net.andrewcpu.elevenlabs.api.transformers;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.util.DebugLogger;

import java.io.File;

public class FilePingPongTransformer extends ResultTransformerAdapter<File> {
	private File file;

	public FilePingPongTransformer(File file) {
		this.file = file;
	}

	@Override
	public File transform() {
		DebugLogger.log(getClass(), file.getAbsolutePath());
		return file;
	}
}
