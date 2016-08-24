package com.seguidor.juanix.primeraapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Juanix on 23/08/2016.
 */
public class DialogActivity extends Activity {

    //Variable para el diálogo en lista
    final CharSequence[] items= {"Blue","Red","Yellow"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Para mostrar un diálogo modal
        //showDialog();
        //showDialogWithList();
        showDialogWithCheckBox();
    }

    //Para crear un diálogo modal
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

    //Para crear un diálogo en lista
    private void showDialogWithList(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("Pick a color");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),items[i],Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alert =builder.create();
        alert.show();
    }

    //Para crear un diálogo con CheckBox
    //Para hacer que sea por CheckBox se añade setSingleChoiceItems y un -1 en seguida indicando item seleccionado por defecto
    private void showDialogWithCheckBox(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("Pick a color");
        builder.setSingleChoiceItems(items, -1,new DialogInterface.OnClickListener() {//El -1 es para indicar el item señalado por defecto
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),items[i],Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alert =builder.create();
        alert.show();
    }
}
