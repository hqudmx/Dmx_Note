package com.dmx.note.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dmx.note.adapter.NoteAdapter;
import com.dmx.note.bean.NoteBean;
import com.dmx.note.model.NoteModel;

public class MainNote extends Activity {
	ImageButton imageButton;
	ListView mListView;
	ArrayList<NoteBean> mArrayList;
	Context mContext;
	NoteAdapter mAdapter;
	EditText mEditText;
	NoteModel model;
	RelativeLayout relativeLayout;
	Button btn_cancle, btn_delete;
	TextView tv_total;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_note);

		mContext = this;
		model = new NoteModel(mContext);
		mArrayList = new ArrayList<NoteBean>();

		relativeLayout = (RelativeLayout) findViewById(R.id.re_longClick);
		btn_cancle = (Button) findViewById(R.id.btn_cancle);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		tv_total = (TextView) findViewById(R.id.total);
		imageButton = (ImageButton) findViewById(R.id.ima_new);
		mListView = (ListView) findViewById(R.id.lv_note);

		mEditText = (EditText) findViewById(R.id.search_edit_note);// 搜索框传入的数据
		mEditText.addTextChangedListener(new TextWatcher() {
			/**
			 * 对EditText监听，实现实时查询
			 */
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String key = mEditText.getText().toString();
				mArrayList = model.queryNote(key);
				mAdapter.setDateChanged(mArrayList);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		/*
		 * mButton.setOnClickListener(new OnClickListener() {
		 * 
		 * //
		 * 模糊匹配查询/////////////////////////////////////////////////////////////
		 * //////////
		 * 
		 * @Override public void onClick(View v) { String key =
		 * mEditText.getText().toString(); mArrayList = model.queryNote(key);
		 * mAdapter.setDateChanged(mArrayList); } });
		 */

		mAdapter = new NoteAdapter(mContext, mArrayList);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				NoteBean oldNote = mArrayList.get(arg2);
				Intent intent = new Intent(mContext, EditNote.class);
				intent.putExtra("oldNote", oldNote);
				startActivity(intent);
			}
		});

		mListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {
				/*
				 * relativeLayout.setVisibility(View.VISIBLE);
				 * btn_cancle.setOnClickListener(new OnClickListener() {
				 * 
				 * @Override public void onClick(View v) {
				 * relativeLayout.setVisibility(View.GONE); } });
				 * 
				 * btn_delete.setOnClickListener(new OnClickListener() {
				 * 
				 * @Override public void onClick(View v) {
				 * 
				 * } });
				 */

				AlertDialog aBuilder = new AlertDialog.Builder(mContext)
						.setTitle("删除")
						.setMessage("确认删除本条内容吗")
						.setPositiveButton("确认",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										NoteBean oldNote = mArrayList.get(arg2);
										model.deleteNote(oldNote);
										mArrayList = model.queryAllNote();
										mAdapter.setDateChanged(mArrayList);
									}
								})
						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
									}
								}).create();
				aBuilder.show();

				return false;
			}
		});
		// 创建新的记事项目
		imageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, NewNote.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mArrayList = model.queryAllNote();
		mAdapter.setDateChanged(mArrayList);
	}

}
