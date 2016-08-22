package com.seguidor.juanix.primeraapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
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
        i.putExtra("ValorPrueba","true");//El segundo valor es la información que se envía, el primero es el id

        startActivity(i);

        access();
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

    public void access(){
        ContentResolver cr=getContentResolver();
        Cursor cur=cr.query(Contacts.People.CONTENT_URI,
                null,null,null,null);
        if (cur.getCount()>0){
            while (cur.moveToNext()){
                String id=cur.getString(cur.getColumnIndex(Contacts.People._ID));
                String name=cur.getString(cur.getColumnIndex(Contacts.People.DISPLAY_NAME));
                Log.d("ContentProvider",name);
            }
        }

    }
}
