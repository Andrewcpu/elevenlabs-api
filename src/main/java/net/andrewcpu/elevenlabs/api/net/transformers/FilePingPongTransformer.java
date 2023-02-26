package net.andrewcpu.elevenlabs.api.net.transformers;

import net.andrewcpu.elevenlabs.util.DebugLogger;

import java.io.File;

public class FilePingPongTransformer extends ResultTransformerAdapter<File> {
	private final File file;

	public FilePingPongTransformer(File file) {
		this.file = file;
	}

	@Override
	public File transform() {
		DebugLogger.log(getClass(), file.getAbsolutePath());
		return file;
	}
}
