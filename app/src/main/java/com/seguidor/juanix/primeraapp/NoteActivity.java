package com.seguidor.juanix.primeraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Juanix on 06/09/2016.
 */
public class NoteActivity extends Activity{

    private Button buttonNotas;
    private LinearLayout linearlayout;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_notas);
        linearlayout = (LinearLayout)findViewById(R.id.layoutNotes);
        buttonNotas = (Button) findViewById(R.id.buttonCreate);
        buttonNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SaveNoteActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        readAndDisplayNotes();
    }

    private void readAndDisplayNotes(){
        File dirFiles=getFilesDir();
        for (String strFile:dirFiles.list()){
            TextView mTextView=new TextView(this);
            //El textView lleva el nombre del fichero
            mTextView.setText(strFile);

            mTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            linearlayout.addView(mTextView);

        }
    }
}
