package net.andrewcpu.elevenlabs.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MapUtil {
	public static String encode(Map<String, String> map) {
		StringBuilder builder = new StringBuilder();
		for(String key : map.keySet()){
			builder.append(URLEncoder.encode(key, StandardCharsets.UTF_8));
			builder.append("=");
			builder.append(URLEncoder.encode(map.get(key)));
			builder.append("&");
		}
		if(builder.toString().length() == 0){
			return "";
		}
		return builder.substring(0,builder.length()-1);
	}
}
