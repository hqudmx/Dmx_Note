package com.dmx.note.activity;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import android.app.Application;
import android.content.Context;

public class UtilAppilycation extends Application {
	Context context;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = this;

		SpeechUtility
				.createUtility(context, SpeechConstant.APPID + "=57d2759a");
	}

}
