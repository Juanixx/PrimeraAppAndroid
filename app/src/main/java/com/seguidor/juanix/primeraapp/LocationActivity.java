package com.seguidor.juanix.primeraapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

/**
 * Created by Juanix on 23/08/2016.
 */
public class LocationActivity extends Activity implements LocationListener {

    private static final long MIN_DISTANCE = 5; //Se le indica una distancia mínima de 5 metros por ejemplo para manejar las localizaciones
    private static final long MIN_TIME = 10 * 1000; //Se le indica un tiempo mínimo de 10 segundos
    private TextView mTextView;
    private LocationManager mLocationManager;
    private String mProvider;//Para poder acceder a un proveedor

    @Override
    public void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.location);

        mTextView = (TextView) findViewById(R.id.locationText);
        /*Para mandar llamar el location Manager, primero se manda castear el objeto,
        * mandando llamar LocationService a través del siguiente método*/


        //el siguiente objeto se encarga de definir criterios a la hora de la localización
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(false);
        criteria.setAltitudeRequired(false);
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//Para un márgen de error pequeño
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //Ahora para indicar el proveedor
        mProvider = mLocationManager.getBestProvider(criteria, true);
        //Después de indicar el proveedor se puede pasar a la petición de actualizaciones en el método onResume

        //Ahora, para obtener la ultima localización
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location localization = mLocationManager.getLastKnownLocation(mProvider);
    }

    //Ahora se pondrá a funcionar el location manager
    @Override
    protected void onResume() {
        super.onResume();
        /*Ahora se hará que el location manager empiece a solicitar actualización de la localización*/

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.requestLocationUpdates(mProvider, MIN_TIME, MIN_DISTANCE, this);
    }

    //Ahora se hará que el location manager deje de pedir actualizaciones
    @Override
    protected void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.removeUpdates(this);
    }

    //Éste método es para cada vez que la localización varía
    @Override
    public void onLocationChanged(Location location) {
        mTextView.append(mTextView.getText().toString()+location.toString()+"\n");
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
