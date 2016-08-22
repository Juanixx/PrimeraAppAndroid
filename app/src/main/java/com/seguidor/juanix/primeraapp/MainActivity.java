package com.seguidor.juanix.primeraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HolaMundo","onCreate");

        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra("ValorPrueba","true");

        startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HolaMundo","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HolaMundo","onResume ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HolaMundo","onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HolaMundo","onDestroy");
    }
}
