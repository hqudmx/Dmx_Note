package com.dmx.note.adapter;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.dmx.note.activity.R;
import com.dmx.note.bean.NoteBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<NoteBean> mArrayList;

	public NoteAdapter(Context mContext, ArrayList<NoteBean> mArrayList) {
		super();
		this.mContext = mContext;
		this.mArrayList = mArrayList;
	}

	@Override
	public int getCount() {
		return mArrayList.size();
	}

	@Override
	public Object getItem(int position) {
		return mArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = inflater.inflate(R.layout.note_bean, null);

		NoteBean noteBean = mArrayList.get(position);

		TextView mTitle = (TextView) view.findViewById(R.id.tv_title);
		TextView mContent = (TextView) view.findViewById(R.id.tv_content);
		TextView mDate = (TextView) view.findViewById(R.id.tv_date);

		mTitle.setText(noteBean.mTitle);
		mContent.setText(noteBean.mContent);

		mDate.setText(getFormateDate(noteBean.mDate));

		return view;
	}

	public String getFormateDate(long time) {
		Date date = new Date(time);
		SimpleDateFormat simple = new SimpleDateFormat("yyyƒÍMM‘¬dd»’  HH:mm");

		String string = simple.format(time);

		return string;
	}
	
	public void setDateChanged(ArrayList<NoteBean> mArrayList){
		this.mArrayList=mArrayList;
		notifyDataSetChanged();
		
	}

}
