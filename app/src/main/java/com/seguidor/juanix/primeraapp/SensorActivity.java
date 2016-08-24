package com.seguidor.juanix.primeraapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by Juanix on 23/08/2016.
 */
public class SensorActivity extends Activity implements SensorEventListener{
    private SensorManager mSensorManager;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList=mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensorList){
            Log.d("Sensor", sensor.getName());

        }

    }

    //Éste método se disparará cada vez que haya nueva información de un sensor
    //Cada sensor puede provocar que se pase por este primer método
    //En éste método se procede a manejar los datos del sensor
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Para evitar que se pase por este método primero, se sincronizará el acceso
        synchronized (this){
            switch (sensorEvent.sensor.getType()){
                case Sensor.TYPE_ACCELEROMETER:
                    for(int i=0; i<3; i++){
                        Log.d("SensorActivity", String.valueOf(sensorEvent.values[i]));
                    }
            }
        }

    }

    //Este método se dispara cada vez que la precisión del sensoor cambie
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
