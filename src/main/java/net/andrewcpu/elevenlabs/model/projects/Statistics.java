package net.andrewcpu.elevenlabs.model.projects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Statistics extends ElevenModel {
	@JsonProperty("characters_unconverted")
	private int charactersUnconverted;

	@JsonProperty("characters_converted")
	private int charactersConverted;

	@JsonProperty("paragraphs_converted")
	private int paragraphsConverted;

	@JsonProperty("paragraphs_unconverted")
	private int paragraphsUnconverted;


	public Statistics(int charactersUnconverted, int charactersConverted, int paragraphsConverted, int paragraphsUnconverted) {
		this.charactersUnconverted = charactersUnconverted;
		this.charactersConverted = charactersConverted;
		this.paragraphsConverted = paragraphsConverted;
		this.paragraphsUnconverted = paragraphsUnconverted;
	}

	public Statistics() {
	}

	@JsonIgnore
	public int getCharactersUnconverted() {
		return charactersUnconverted;
	}

	@JsonIgnore
	public int getCharactersConverted() {
		return charactersConverted;
	}

	@JsonIgnore
	public int getParagraphsConverted() {
		return paragraphsConverted;
	}

	@JsonIgnore
	public int getParagraphsUnconverted() {
		return paragraphsUnconverted;
	}


	@Override
	@JsonIgnore
	public String toString() {
		return "Statistics{" +
				"charactersUnconverted=" + charactersUnconverted +
				", charactersConverted=" + charactersConverted +
				", paragraphsConverted=" + paragraphsConverted +
				", paragraphsUnconverted=" + paragraphsUnconverted +
				'}';
	}
}
