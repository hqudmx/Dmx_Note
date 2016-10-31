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
	//1.创建SpeechRecognizer对象，第二个参数：本地听写时传InitListener    
	SpeechRecognizer mIat= SpeechRecognizer.createRecognizer(context, null);    
	//2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类    
	mIat.setParameter(SpeechConstant.DOMAIN, "iat");    
	mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");    
	mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");    
	//3.开始听写   mIat.startListening(mRecoListener);    
	//听写监听器    
	private RecognizerListener mRecoListener = new RecognizerListener(){    
	//听写结果回调接口(返回Json格式结果，用户可参见附录12.1)；    
	//一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；    
	//关于解析Json的代码可参见MscDemo中JsonParser类；    
	//isLast等于true时会话结束。    
	public void onResult(RecognizerResult results, boolean isLast) {    
	            Log.d("Result:",results.getResultString ());}    
	//会话发生错误回调接口    
	    public void onError(SpeechError error) {    
	error.getPlainDescription(true) //获取错误码描述}    
	    //开始录音    
	    public void onBeginOfSpeech() {}    
	    //音量值0~30    
	    public void onVolumeChanged(int volume){}    
	    //结束录音    
	    public void onEndOfSpeech() {}    
	    //扩展用接口    
	    public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {}    
	}; 
}

*/