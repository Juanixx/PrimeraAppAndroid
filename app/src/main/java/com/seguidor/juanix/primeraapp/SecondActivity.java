package com.seguidor.juanix.primeraapp;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String varString=getIntent().getStringExtra("ValorPrueba");
        Log.d("HolaMundo=SecondActvt", varString);
    }
}
