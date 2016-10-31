package com.dmx.note.bean;

import java.io.Serializable;

public class NoteBean implements Serializable {
	public String mTitle;
	public String mContent;
	public long mDate;
	public NoteBean(String mTitle, String mContent, long mDate) {
		super();
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mDate = mDate;
	}

}
