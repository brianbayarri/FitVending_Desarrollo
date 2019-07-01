package com.example.fitvending;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PantallaDeCarga extends AppCompatActivity {

    private int tiempo = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter(); // get Bluetooth adapter

        if(btAdapter==null) {
            Toast.makeText(getBaseContext(), "El dispositivo no soporta bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (btAdapter.isEnabled()) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }



        //Aca poner los permisos

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación

                Intent intent = new Intent(PantallaDeCarga.this, LoginActivity.class);
                startActivity(intent);
                finish();
            };
        }, tiempo);
    }



    public void onResume(){

        super.onResume();

        Intent service = new Intent(getBaseContext(),BtConnectionService.class);
        startService(service);


    }

}
