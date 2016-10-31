package com.dmx.note.model;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dmx.note.bean.NoteBean;
import com.dmx.note.db.NoteHelper;

public class NoteModel {
	SQLiteDatabase writeDatabase;
	SQLiteDatabase readerDatabase;
	Context mContext;
	NoteHelper noteHelper;

	public NoteModel(Context mContext) {
		super();
		this.mContext = mContext;
		noteHelper = new NoteHelper(mContext);
		readerDatabase = noteHelper.getReadableDatabase();
		writeDatabase = noteHelper.getWritableDatabase();
	}

	/**
	 * ��������
	 */
	public void insertNote(NoteBean note) {
		ContentValues cv = new ContentValues();
		cv.put("title", note.mTitle);
		cv.put("content", note.mContent);
		cv.put("date", note.mDate);
		writeDatabase.insert("note", null, cv);
	}

	/**
	 * ɾ������
	 */
	public void deleteNote(NoteBean oldNote) {
		writeDatabase.delete("note", "title=? and content=? and date=?",
				new String[] { oldNote.mTitle, oldNote.mContent,
						oldNote.mDate + "" });
	}

	/**
	 * �޸�����
	 */
	public void updateNote(NoteBean oldNote, NoteBean newNote) {
		ContentValues cv = new ContentValues();
		cv.put("title", newNote.mTitle);
		cv.put("content", newNote.mContent);
		cv.put("date", newNote.mDate);
		writeDatabase.update("note", cv, "title=? and content=? and date=?",
				new String[] { oldNote.mTitle, oldNote.mContent,
						oldNote.mDate + "" });
	}

	/**
	 * ����ȫ�����ݣ���ʾ��MainNote
	 */
	public ArrayList<NoteBean> queryAllNote() {
		ArrayList<NoteBean> notes = new ArrayList<NoteBean>();
		Cursor cursor = readerDatabase.query("note", null, null, null, null,
				null, null);
		while (cursor.moveToNext()) {
			String title = cursor.getString(cursor.getColumnIndex("title"))
					.toString();
			String content = cursor.getString(cursor.getColumnIndex("content"))
					.toString();
			long date = cursor.getLong(cursor.getColumnIndex("date"));
			NoteBean note = new NoteBean(title, content, date);
			notes.add(note);
		}
		return notes;
	}

	/**
	 * ģ��ƥ��
	 */
	public ArrayList<NoteBean> queryNote(String key) {
		ArrayList<NoteBean> notes = new ArrayList<NoteBean>();
		Cursor cursor = readerDatabase.query("note", null, "title like '%"
				+ key + "%' or  content like '%" + key + "%'", null, null,
				null, null);
		// Toast.makeText(mContext, "���ڲ�ѯ", 1000).show();
		while (cursor.moveToNext()) {
			// Toast.makeText(mContext, "��ѯ�ɹ�", 1000).show();
			String title = cursor.getString(cursor.getColumnIndex("title"))
					.toString();
			String content = cursor.getString(cursor.getColumnIndex("content"))
					.toString();
			long date = cursor.getLong(cursor.getColumnIndex("date"));
			NoteBean note = new NoteBean(title, content, date);
			notes.add(note);
		}
		return notes;
	}
}
