package net.andrewcpu.elevenlabs.model.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.util.ElevenNetworkUtil;

import java.io.File;
import java.util.Map;

public class HistoryItem extends ElevenModel {
	@JsonProperty("history_item_id")
	private String historyItemId;

	@JsonProperty("request_id")
	private String requestId;

	@JsonProperty("voice_id")
	private String voiceId;

	@JsonProperty("voice_name")
	private String voiceName;

	@JsonProperty("text")
	private String text;

	@JsonProperty("date_unix")
	private long dateUnix;

	@JsonProperty("character_count_change_from")
	private int characterCountChangeFrom;

	@JsonProperty("character_count_change_to")
	private int characterCountChangeTo;

	@JsonProperty("content_type")
	private String contentType;

	@JsonProperty("state")
	private String state;

	@JsonProperty("settings")
	private Map<String, Object> settings;

	@JsonProperty("feedback")
	private Feedback feedback;

	public HistoryItem(String historyItemId, String requestId, String voiceId, String voiceName, String text, long dateUnix, int characterCountChangeFrom, int characterCountChangeTo, String contentType, String state, Map<String, Object> settings, Feedback feedback) {
		this.historyItemId = historyItemId;
		this.requestId = requestId;
		this.voiceId = voiceId;
		this.voiceName = voiceName;
		this.text = text;
		this.dateUnix = dateUnix;
		this.characterCountChangeFrom = characterCountChangeFrom;
		this.characterCountChangeTo = characterCountChangeTo;
		this.contentType = contentType;
		this.state = state;
		this.settings = settings;
		this.feedback = feedback;
	}

	public HistoryItem() {
	}

	@JsonIgnore
	public String getHistoryItemId() {
		return historyItemId;
	}

	@JsonIgnore
	public String getRequestId() {
		return requestId;
	}

	@JsonIgnore
	public String getVoiceId() {
		return voiceId;
	}

	@JsonIgnore
	public String getVoiceName() {
		return voiceName;
	}

	@JsonIgnore
	public String getText() {
		return text;
	}

	@JsonIgnore
	public long getDateUnix() {
		return dateUnix;
	}

	@JsonIgnore
	public int getCharacterCountChangeFrom() {
		return characterCountChangeFrom;
	}

	@JsonIgnore
	public int getCharacterCountChangeTo() {
		return characterCountChangeTo;
	}

	@JsonIgnore
	public String getContentType() {
		return contentType;
	}

	@JsonIgnore
	public String getState() {
		return state;
	}

	@JsonIgnore
	public Map<String, Object> getSettings() {
		return settings;
	}

	@JsonIgnore
	public Feedback getFeedback() {
		return feedback;
	}

	public String delete() {
		return ElevenLabs.getHistoryAPI().deleteHistoryItem(historyItemId);
	}

	public File downloadAudio() {
		return ElevenLabs.getHistoryAPI().getHistoryItemAudio(historyItemId);
	}

	public String getDownloadUrl() {
		return ElevenNetworkUtil.getHistoryItemUrl(historyItemId);
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "HistoryItem{" +
				"historyItemId='" + historyItemId + '\'' +
				", requestId='" + requestId + '\'' +
				", voiceId='" + voiceId + '\'' +
				", voiceName='" + voiceName + '\'' +
				", text='" + text + '\'' +
				", dateUnix=" + dateUnix +
				", characterCountChangeFrom=" + characterCountChangeFrom +
				", characterCountChangeTo=" + characterCountChangeTo +
				", contentType='" + contentType + '\'' +
				", state='" + state + '\'' +
				", settings=" + settings +
				", feedback=" + feedback +
				'}';
	}
}
