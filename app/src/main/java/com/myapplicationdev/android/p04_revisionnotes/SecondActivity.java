package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ArrayList<Note> notes;
	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> newNote;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		Intent i = getIntent();
		boolean isGood = i.getBooleanExtra("isGood",false);

		lv=findViewById(R.id.lv);
		DBHelper db = new DBHelper(SecondActivity.this);
		notes = db.getAllNotes();
		db.close();
		aa = new RevisionNotesArrayAdapter(SecondActivity.this,R.layout.row,notes);
		lv.setAdapter(aa);

	}


}
