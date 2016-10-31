package com.dmx.note.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dmx.note.bean.NoteBean;
import com.dmx.note.model.NoteModel;

public class EditNote extends Activity implements OnClickListener {
	ImageButton btn_back, btn_save;
	TextView tv_date;
	EditText ed_title, ed_content;
	long time;
	Context mContext;
	NoteModel model;
	NoteBean oldNote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.edit_note);
		mContext = this;
		model = new NoteModel(mContext);

		btn_back = (ImageButton) findViewById(R.id.id_back);
		btn_back.setOnClickListener(this);

		btn_save = (ImageButton) findViewById(R.id.id_finish);
		btn_save.setOnClickListener(this);

		ed_title = (EditText) findViewById(R.id.title_edit);
		ed_content = (EditText) findViewById(R.id.content_edit);

		tv_date = (TextView) findViewById(R.id.date_tv);
		time = System.currentTimeMillis();
		tv_date.setText(getFormateDate(time));

		if (getIntent() != null) {
			oldNote = (NoteBean) getIntent().getSerializableExtra("oldNote");
			ed_title.setText(oldNote.mTitle);
			/*Selection selection;
			selection.setSelection(oldNote.mTitle, oldNote.mTitle.length());*/
			ed_content.setText(oldNote.mContent);
		}
	}

	public String getFormateDate(long time) {
		Date date = new Date(time);
		SimpleDateFormat simple = new SimpleDateFormat("yyy年MM月dd日  HH:mm");
		String string = simple.format(time);
		return string;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_back: // 返回首页
			finish();
			break;
		case R.id.id_finish: // 保存内容
			String title = ed_title.getText().toString();
			String content = ed_content.getText().toString();
			long date = time;
			model.updateNote(oldNote, new NoteBean(title, content, date));
			finish();
			break;

		}
	}
}
