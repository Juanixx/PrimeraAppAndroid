package com.seguidor.juanix.primeraapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Juanix on 23/08/2016.
 */
public class DialogActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        showDialog();
    }

    private void showDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Titulo")
                .setMessage("¿Cerrar aplicación?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Dialog","Seguimos en la aplicación");
                    }
                }).show();
    }
}
