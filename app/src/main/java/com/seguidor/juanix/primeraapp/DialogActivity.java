package com.seguidor.juanix.primeraapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Juanix on 23/08/2016.
 */
public class DialogActivity extends Activity {

    //Variable para el diálogo en lista
    final CharSequence[] items= {"Blue","Red","Yellow"};
    private ProgressDialog barProgressDialog;

    //Para crear handlers
    //El handler permite manejar la post ejecución del handler
    private Handler updateBarHandler;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        showBarDialog();
        //Para mostrar un diálogo modal
        //showDialog();
        //showDialogWithList();
        //showDialogWithCheckBox();
        //showRingDialog();



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

    //Para crear un diálogo de progreso, como una barra o un círculo cargándose

    //En éste caso un círculo cargándose
    private void showRingDialog(){
        final ProgressDialog ringProgressDialog = ProgressDialog.show(DialogActivity.this, "Espere", "Descargando..", true);
        ringProgressDialog.setCancelable(true);//Con esto se especifica si el dialogo es removible de la pantalla

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }

    //En éste caso una barra cargándose
    private void showBarDialog(){
        barProgressDialog = new ProgressDialog(DialogActivity.this);

        barProgressDialog.setTitle("Espere...");
        barProgressDialog.setMessage("Descargando");
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
        barProgressDialog.setProgress(0);
        barProgressDialog.setMax(20);
        barProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                while (barProgressDialog.getProgress() <= barProgressDialog.getMax());//El progreso es menor o igual al máximo especificado anteriormente

                    Thread.sleep(2000);//Cada dos segundos
                    //Apartir de aquí se controla la post ejecución del hilo
                    //Con ésto, se incrementará de dos en dos la barra hasta llegar al maximo, que es 20
                    updateBarHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            barProgressDialog.incrementProgressBy(2);
                        }
                    });
                    if (barProgressDialog.getProgress() == barProgressDialog.getMax()){
                        barProgressDialog.dismiss();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }
}
