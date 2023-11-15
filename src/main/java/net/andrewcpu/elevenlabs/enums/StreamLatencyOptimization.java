package net.andrewcpu.elevenlabs.enums;

public enum StreamLatencyOptimization {
	//0 - default mode (no latency optimizations)
	NONE(0),
	//1 - normal latency optimizations (about 50% of possible latency improvement of option 3)
	NORMAL(1),
	//2 - strong latency optimizations (about 75% of possible latency improvement of option 3)
	STRONG(2),
	// 3 - max latency optimizations
	MAX_TEXT_NORMALIZATION(3),
	// 3 - max latency optimizations with text normalizer turned off
	MAX_NO_TEXT_NORMALIZATION(4);
	private final int value;

	StreamLatencyOptimization(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static StreamLatencyOptimization getDefault() {
		return NONE;
	}
}
