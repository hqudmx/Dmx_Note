package com.dmx.note.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class XunFeiJsonUtil {
	public static String parseIatResult(String json) {
		StringBuffer ret = new StringBuffer();
		try {
			JSONTokener tokener = new JSONTokener(json);
			JSONObject joResult = new JSONObject(tokener);
			JSONArray words = joResult.getJSONArray("ws");
			for (int i = 0; i < words.length(); i++) { // ��д����ʣ�Ĭ��ʹ�õ�һ�����
				JSONArray items = words.getJSONObject(i).getJSONArray("cw");
				JSONObject obj = items.getJSONObject(0);
				ret.append(obj.getString("w"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret.toString();
	}

}
