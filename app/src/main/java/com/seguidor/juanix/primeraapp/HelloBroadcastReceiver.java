package com.seguidor.juanix.primeraapp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Juanix on 22/08/2016.
 */
public class HelloBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Broadcast Receiver", "Power is connected");
    }
}
