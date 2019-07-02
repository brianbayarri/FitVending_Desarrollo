package com.example.fitvending;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitvending.Datos.DBHandler;
import com.example.fitvending.Datos.UsuarioDAO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class SensorsService extends Service implements SensorEventListener {

    private SensorManager sensorManager;

    //PASOS
    private int pasosDados;
    private static int b;
    private static float pasos_iniciales;
    private static float pasos_actuales;

    //SHAKE
    private float acelVal;
    private float acelLast;
    private float shake;

    //PROXIMIDAD
    private int modificaciones;

    //Hora
    private long fechaActual,fechaInicioMillis;
    public static long millisEnHora = 3600000; //EQUIVALE A UNA HORA EN MILISEGUNDOS
    public static long minEnMillis = 60000; //EQUIVALE A UN MINUTO EN MILISEGUNDOS
    public static long cincosegEnMillis = 5000; //EQUIVALE A UN 5 SEGUNDOS EN MILISEGUNDOS

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;
        b=0;


        modificaciones = 0;

        fechaInicioMillis = Calendar.getInstance().getTimeInMillis(); //OBTENGO LA FECHA EN QUE SE INICIA EL SERVICE


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor shakeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Contador de pasos no disponible", Toast.LENGTH_LONG).show();
        }

        if (shakeSensor != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "Acelerometro no disponible", Toast.LENGTH_LONG).show();
        }

        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor de proximidad no disponible", Toast.LENGTH_LONG).show();
        }

        return START_STICKY;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(b==0 && event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            pasos_iniciales = event.values[0];
            b=1;
        }

        if(event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {

            fechaActual = Calendar.getInstance().getTimeInMillis(); //OBTENGO LA FECHA EN QUE SE HACE UN PASO
            pasos_actuales = event.values[0];
            Toast.makeText(this, "pasos dados: "+ pasos_actuales, Toast.LENGTH_LONG).show();

            if ((fechaActual - fechaInicioMillis) > millisEnHora) //SI LA RESTA ENTRE LA HORA DEL PASO Y LA HORA DE INICIO SUPERA UNA HORA (AHORA ESTA EN UN MINUTO PARA PROBAR) DEBERIA ENTRAR AL IF Y GUARDAR CALORIAS
            {
                fechaInicioMillis = Calendar.getInstance().getTimeInMillis(); //ACA RESETEO LA HORA DE INICIO A LA HORA EN QUE SE GUARDAN LAS CALORIAS

                float pasos = pasos_actuales - pasos_iniciales;
                String pasostext = String.valueOf(pasos);
                Toast.makeText(this, "pasos almacenados: "+ pasostext, Toast.LENGTH_LONG).show();
                ///guardar pasos en la base
                pasos_iniciales = pasos_actuales;
            }
        }
        else if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            acelLast=acelVal;
            acelVal= (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = acelVal-acelLast;
            shake = shake * 0.9f + delta;

            if(shake>18) {
               // Toast.makeText(this, "Usted me enciende, digo agita", Toast.LENGTH_LONG).show();
                BtConnectionService.enviarDatosAArduino("5");

            }

        }
        else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            modificaciones++;
            if(modificaciones == 10){
               // Toast.makeText(this, "Ha pulsado el sensor por 10 veces", Toast.LENGTH_LONG).show();
                BtConnectionService.enviarDatosAArduino("6");
                modificaciones=0;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("hh:mm:ss:Z");
        String strDate = mdformat.format(calendar.getTime());
        return strDate;
    }

}
