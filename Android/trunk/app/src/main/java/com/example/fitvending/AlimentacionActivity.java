package com.example.fitvending;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Switch;

public class AlimentacionActivity extends AppCompatActivity {

    public static final int VERDE_REF = Color.rgb(124, 213, 22);
    public static final int GRIS_REF = Color.rgb(128, 128, 128);
    Switch sw_desayuno, sw_almuerzo, sw_cena, sw_colacion;
    Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);
        sw_desayuno=findViewById(R.id.sw_desayuno);
        sw_almuerzo=findViewById(R.id.sw_almuerzo);
        sw_cena=findViewById(R.id.sw_cena);
        sw_colacion=findViewById(R.id.sw_colacion);

        sw_desayuno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    sw_desayuno.setThumbTintList(ColorStateList.valueOf(VERDE_REF));
                    sw_desayuno.setTrackTintList(ColorStateList.valueOf(VERDE_REF));
                }
                else {
                    sw_desayuno.setThumbTintList(ColorStateList.valueOf(GRIS_REF));
                    sw_desayuno.setTrackTintList(ColorStateList.valueOf(GRIS_REF));
                }
            }
        });

        sw_almuerzo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    sw_almuerzo.setThumbTintList(ColorStateList.valueOf(VERDE_REF));
                    sw_almuerzo.setTrackTintList(ColorStateList.valueOf(VERDE_REF));
                }
                else {
                    sw_almuerzo.setThumbTintList(ColorStateList.valueOf(GRIS_REF));
                    sw_almuerzo.setTrackTintList(ColorStateList.valueOf(GRIS_REF));
                }
            }
        });

        sw_cena.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    sw_cena.setThumbTintList(ColorStateList.valueOf(VERDE_REF));
                    sw_cena.setTrackTintList(ColorStateList.valueOf(VERDE_REF));
                }
                else {
                    sw_cena.setThumbTintList(ColorStateList.valueOf(GRIS_REF));
                    sw_cena.setTrackTintList(ColorStateList.valueOf(GRIS_REF));
                }
            }
        });

        sw_colacion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    sw_colacion.setThumbTintList(ColorStateList.valueOf(VERDE_REF));
                    sw_colacion.setTrackTintList(ColorStateList.valueOf(VERDE_REF));
                }
                else {
                    sw_colacion.setThumbTintList(ColorStateList.valueOf(GRIS_REF));
                    sw_colacion.setTrackTintList(ColorStateList.valueOf(GRIS_REF));
                }
            }
        });
    }


}
