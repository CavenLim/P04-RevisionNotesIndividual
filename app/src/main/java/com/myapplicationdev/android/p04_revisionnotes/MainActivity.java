package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText note;
    RadioGroup rgStars;
    RadioButton rb;
    Button btnInsert,btnShow,btnGood;
    int selectedStar ;
    String noteContent;
    ArrayList<Note> notes;
    ArrayList<String> notesFetched;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note= findViewById(R.id.editTextNote);
        rgStars = findViewById(R.id.radioGroupStars);


        btnInsert=findViewById(R.id.buttonInsertNote);
        btnShow=findViewById(R.id.buttonShowList);
        btnGood = findViewById(R.id.buttonGood);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                rb = findViewById( rgStars.getCheckedRadioButtonId());
                noteContent=note.getText().toString();
                if (!noteContent.isEmpty()){
                    notesFetched = db.getNoteContent();
                        if (!notesFetched.contains(noteContent)){
                            db.insertNote(noteContent,Integer.valueOf(rb.getText().toString()));
                            db.close();
                            Toast.makeText(MainActivity.this, "Inserted",
                                    Toast.LENGTH_LONG).show();
                        }

                }


            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        btnGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("isGood",true);
                startActivity(intent);
            }
        });





    }
}
