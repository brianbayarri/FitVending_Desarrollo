package com.example.fitvending;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class AlimentacionActivity extends AppCompatActivity {

    public static final int VERDE_REF = Color.rgb(124, 213, 22);
    public static final int GRIS_REF = Color.rgb(128, 128, 128);
    Switch sw_desayuno, sw_almuerzo, sw_cena, sw_colacion;
    Spinner sp_plato, sp_guarnicion, sp_bebida, sp_porcion1, sp_porcion2, sp_porcion3;
    Button btn_cancelar;

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);
        btn_cancelar=findViewById(R.id.btn_cancelar);

        sw_desayuno=findViewById(R.id.sw_desayuno);
        sw_almuerzo=findViewById(R.id.sw_almuerzo);
        sw_cena=findViewById(R.id.sw_cena);
        sw_colacion=findViewById(R.id.sw_colacion);

        sp_plato=findViewById(R.id.sp_plato_principal);
        sp_guarnicion=findViewById(R.id.sp_guarnicion);
        sp_bebida=findViewById(R.id.sp_guarnicion);
        sp_porcion1=findViewById(R.id.sp_porcion1);
        sp_porcion2=findViewById(R.id.sp_porcion2);
        sp_porcion3=findViewById(R.id.sp_porcion3);

        final ArrayAdapter<String> adap_desayuno;
        final ArrayAdapter<String> adap_plato;
        final ArrayAdapter<String> adap_colacion;
        final ArrayAdapter<String> adap_porcion;
        final ArrayAdapter<Integer> adap_cantidad;

        ArrayList<String> l_desayuno = new ArrayList<>();
        l_desayuno.add("Medialunas");
        l_desayuno.add("Omelet");
        l_desayuno.add("Huevos y panceta");
        l_desayuno.add("Tostado");
        adap_desayuno = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,l_desayuno);

        ArrayList<String> l_plato = new ArrayList<>();
        l_plato.add("Pollo");
        l_plato.add("Carne");
        l_plato.add("Pescado");
        l_plato.add("Ensalada");
        adap_plato = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,l_plato);

        ArrayList<String> l_colacion = new ArrayList<>();
        l_colacion.add("Barra cereal");
        l_colacion.add("Banana");
        l_colacion.add("Yogurt");
        l_colacion.add("Sanguche JyQ");
        adap_colacion = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,l_colacion);

        ArrayList<String> l_porcion = new ArrayList<>();
        l_porcion.add("Chica (100gr)");
        l_porcion.add("Mediana (150gr)");
        l_porcion.add("Grande(300gr");
        adap_porcion = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,l_porcion);

        ArrayList<Integer> l_cantidad = new ArrayList<>();
        l_cantidad.add(1);
        l_cantidad.add(2);
        l_cantidad.add(3);
        adap_cantidad = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item,l_cantidad);

        sw_desayuno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    sw_desayuno.setThumbTintList(ColorStateList.valueOf(VERDE_REF));
                    sw_desayuno.setTrackTintList(ColorStateList.valueOf(VERDE_REF));
                    sw_almuerzo.setChecked(false);
                    sw_cena.setChecked(false);
                    sw_colacion.setChecked(false);
                    sp_plato.setAdapter(adap_desayuno);
                    sp_porcion1.setAdapter(adap_porcion);
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
                    sw_desayuno.setChecked(false);
                    sw_cena.setChecked(false);
                    sw_colacion.setChecked(false);
                    sp_plato.setAdapter(adap_plato);
                    sp_porcion1.setAdapter(adap_porcion);
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
                    sw_desayuno.setChecked(false);
                    sw_almuerzo.setChecked(false);
                    sw_colacion.setChecked(false);
                    sp_plato.setAdapter(adap_plato);
                    sp_porcion1.setAdapter(adap_porcion);
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
                    sw_desayuno.setChecked(false);
                    sw_almuerzo.setChecked(false);
                    sw_cena.setChecked(false);
                    sp_plato.setAdapter(adap_colacion);
                    sp_porcion1.setAdapter(adap_cantidad);
                }
                else {
                    sw_colacion.setThumbTintList(ColorStateList.valueOf(GRIS_REF));
                    sw_colacion.setTrackTintList(ColorStateList.valueOf(GRIS_REF));
                }
            }


        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reload();
            }
        });

    }


}
