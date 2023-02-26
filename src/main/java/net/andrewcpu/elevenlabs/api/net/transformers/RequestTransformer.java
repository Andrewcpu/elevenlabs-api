package net.andrewcpu.elevenlabs.api.net.transformers;

import net.andrewcpu.elevenlabs.api.net.transformers.obj.*;
import net.andrewcpu.elevenlabs.elements.user.Subscription;
import net.andrewcpu.elevenlabs.elements.user.User;
import net.andrewcpu.elevenlabs.elements.voice.History;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import org.json.simple.JSONObject;

import java.util.List;

public class RequestTransformer {
	public static final ResultTransformer<Voice> VOICE_TRANSFORMER = new VoiceTransformer();
	public static final ResultTransformer<VoiceSettings> VOICE_SETTINGS_TRANSFORMER = new VoiceSettingTransformer();
	public static final ResultTransformer<History> HISTORY_TRANSFORMER = new HistoryTransformer();
	public static final ResultTransformer<User> USER_TRANSFORMER = new UserTransformer();
	public static final ResultTransformer<Subscription> SUBSCRIPTION_TRANSFORMER = new SubscriptionTransformer();
	public static final ResultTransformer<List<Voice>> VOICE_LIST_TRANSFORMER = new VoiceListTransformer();
	public static final ResultTransformer<String> STRING_RESULT_TRANSFORMER = new StringPingPongTransformer();
	public static final ResultTransformer<String> VOICE_ID_TRANSFORMER = new VoiceIDTransformer();

	public static final ResultTransformer<JSONObject> IN_OUT_TRANSFORMER = new ResultTransformerAdapter<JSONObject>(){
		@Override
		public JSONObject transform(JSONObject object) {
			return object;
		}
	};
}
