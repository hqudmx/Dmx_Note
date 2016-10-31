package com.dmx.note.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteHelper extends SQLiteOpenHelper {

	public NoteHelper(Context context) {
		super(context, "NoteDB", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_note_sql = "create table note("
				+ "id integer primary key autoincrement , title text , content  text,date text"
				+ ")";
		db.execSQL(create_note_sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
