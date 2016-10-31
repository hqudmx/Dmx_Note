package com.dmx.note.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dmx.note.bean.NoteBean;
import com.dmx.note.model.NoteModel;
import com.dmx.note.utils.XunFeiJsonUtil;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

public class NewNote extends Activity implements OnClickListener {
	ImageView btn_back, btn_save;
	TextView tv_date;
	EditText ed_title, ed_content;
	NoteModel noteModel;
	Context mContext;
	ImageView voice;
	long time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.new_note);
		mContext = this;
		noteModel = new NoteModel(mContext);

		btn_back = (ImageView) findViewById(R.id.id_back);
		btn_back.setOnClickListener(this);

		btn_save = (ImageView) findViewById(R.id.id_finish);
		btn_save.setOnClickListener(this);

		ed_title = (EditText) findViewById(R.id.title_edit);
		ed_content = (EditText) findViewById(R.id.content_edit);

		tv_date = (TextView) findViewById(R.id.date_tv);
		time = System.currentTimeMillis();
		tv_date.setText(getFormateDate(time));

		voice = (ImageView) findViewById(R.id.new_note_voice);
		voice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RecognizerDialog iatDialog = new RecognizerDialog(mContext,
						null);
				//iatDialog.setListener();
				iatDialog.setListener(new RecognizerDialogListener() {
					@Override
					public void onResult(RecognizerResult arg0, boolean arg1) {
						Log.i("dmx", "sss");
						String str = XunFeiJsonUtil.parseIatResult(arg0
								.getResultString());
						if (!arg1) {
							ed_title.append(str);
						}
					}

					@Override
					public void onError(SpeechError arg0) {
						Log.i("dmx", "error"+arg0);
					}
				});
				iatDialog.show();
				Log.i("dmx", "aaaa");
			}
		});

	}

	/**
	 * 
	 */
	// RecognizerDialogListener mRecognizerDialogListener = new
	// RecognizerDialogListener() {
	// @Override
	// public void onResult(RecognizerResult arg0, boolean arg1) {
	// Log.i("dmx", "xunfei");
	// String str = XunFeiJsonUtil.parseIatResult(arg0.getResultString());
	// // ƴ��
	// if (!arg1) {
	// ed_title.append(str);
	// }
	// }
	//
	// @Override
	// public void onError(SpeechError arg0) {
	//
	// }
	// };

	public String getFormateDate(long time) {
		Date date = new Date(time);
		SimpleDateFormat simple = new SimpleDateFormat("yyy��MM��dd��  HH:mm");
		String string = simple.format(time);
		return string;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_back: // ������ҳ
			finish();
			break;
		case R.id.id_finish: // ��������
			// Toast.makeText(NewNote.this, "baocun", 1000).show();
			String title = ed_title.getText().toString();
			String content = ed_content.getText().toString();
			long date = time;

			NoteBean noteBean = new NoteBean(title, content, date);
			noteModel.insertNote(noteBean);

			finish();
			break;
		// case R.id.new_note_voice:
		// Toast.makeText(mContext, "voice", 1000).show();
		// RecognizerDialog reDioa = new RecognizerDialog(mContext, null);
		// reDioa.setListener(mRecognizerDialogListener);
		// reDioa.show();
		// break;

		}

	}

	// ������������ļ�����
	// RecognizerDialogListener mRecognizerDialogListener = new
	// RecognizerDialogListener() {
	// public void onResult(RecognizerResult results, boolean isLast) {
	// // ��ӡ��� ��isLastΪtrueʱ,˵���������
	// Log.i("dmx", "Ѷ������");
	// String str = XunFeiJsonUtil.parseIatResult(results
	// .getResultString());
	// // ƴ��
	// if (!isLast) {
	// ed_title.append(str);
	// }
	// }
	//
	// public void onError(SpeechError error) {
	// // ����
	// }
	// };

}
