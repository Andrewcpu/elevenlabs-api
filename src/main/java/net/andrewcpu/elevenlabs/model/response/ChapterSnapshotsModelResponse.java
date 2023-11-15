package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.projects.ChapterSnapshot;

import java.util.List;

public class ChapterSnapshotsModelResponse extends ElevenModel {

	public ChapterSnapshotsModelResponse(List<ChapterSnapshot> snapshots) {
		this.snapshots = snapshots;
	}

	public ChapterSnapshotsModelResponse() {
	}

	@JsonProperty("snapshots")
	private List<ChapterSnapshot> snapshots;


	@JsonIgnore
	public List<ChapterSnapshot> getSnapshots() {
		return snapshots;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "ChapterSnapshotsModelResponse{" +
				"snapshots=" + snapshots +
				'}';
	}
}
