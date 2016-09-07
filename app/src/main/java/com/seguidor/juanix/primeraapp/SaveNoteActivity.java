package com.seguidor.juanix.primeraapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Juanix on 06/09/2016.
 */
public class SaveNoteActivity extends Activity{

    private EditText editText;
    private Button saveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_note);
        editText = (EditText) findViewById(R.id.editTextNota);
        saveNote = (Button) findViewById(R.id.buttonSaveNote);

        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long unixTime= System.currentTimeMillis()/1000L;
                String nameFile = String.valueOf(unixTime);
                try {
                    saveIntoFile(nameFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void saveIntoFile(String nameFile) throws IOException {
        try {
            FileOutputStream outputStream = openFileOutput(nameFile, Context.MODE_PRIVATE);
            outputStream.write(editText.getText().toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
    }
