/*package com.dmx.note.utils;

import android.content.Context;
import android.speech.SpeechRecognizer;

import com.iflytek.speech.RecognizerListener;

public class Snippet {
	Context context;
	
}
	public Snippet(Context context) {
		super();
		this.context = context;
	}
	//1.����SpeechRecognizer���󣬵ڶ���������������дʱ��InitListener    
	SpeechRecognizer mIat= SpeechRecognizer.createRecognizer(context, null);    
	//2.������д������������ƴ�Ѷ��MSC API�ֲ�(Android)��SpeechConstant��    
	mIat.setParameter(SpeechConstant.DOMAIN, "iat");    
	mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");    
	mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");    
	//3.��ʼ��д   mIat.startListening(mRecoListener);    
	//��д������    
	private RecognizerListener mRecoListener = new RecognizerListener(){    
	//��д����ص��ӿ�(����Json��ʽ������û��ɲμ���¼12.1)��    
	//һ������»�ͨ��onResults�ӿڶ�η��ؽ����������ʶ�������Ƕ�ν�����ۼӣ�    
	//���ڽ���Json�Ĵ���ɲμ�MscDemo��JsonParser�ࣻ    
	//isLast����trueʱ�Ự������    
	public void onResult(RecognizerResult results, boolean isLast) {    
	            Log.d("Result:",results.getResultString ());}    
	//�Ự��������ص��ӿ�    
	    public void onError(SpeechError error) {    
	error.getPlainDescription(true) //��ȡ����������}    
	    //��ʼ¼��    
	    public void onBeginOfSpeech() {}    
	    //����ֵ0~30    
	    public void onVolumeChanged(int volume){}    
	    //����¼��    
	    public void onEndOfSpeech() {}    
	    //��չ�ýӿ�    
	    public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {}    
	}; 
}

*/