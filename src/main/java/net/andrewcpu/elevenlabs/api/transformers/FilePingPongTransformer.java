package net.andrewcpu.elevenlabs.api.transformers;

import java.io.File;

public class FilePingPongTransformer extends ResultTransformerAdapter<File> {
	private File file;

	public FilePingPongTransformer(File file) {
		this.file = file;
	}

	@Override
	public File transform() {
		return file;
	}
}
