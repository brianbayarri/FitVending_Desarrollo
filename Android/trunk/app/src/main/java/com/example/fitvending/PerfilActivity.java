package com.example.fitvending;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {

    EditText lbl_altura, lbl_edad, lbl_peso;
    Spinner sp_sexo;
    TextView cal_num;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        lbl_altura=findViewById(R.id.editlbl_Altura);
        lbl_edad=findViewById(R.id.editlbl_edad);
        lbl_peso=findViewById(R.id.editlbl_Peso);
        sp_sexo=findViewById(R.id.sp_sexo);
        cal_num=findViewById(R.id.lbl_CaloriasNum);
        boton=findViewById(R.id.boton);
        final ArrayAdapter<String> adap_sexo;

        ArrayList<String> l_sexo = new ArrayList<>();
        l_sexo.add("H");
        l_sexo.add("M");
        adap_sexo = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,l_sexo);
        sp_sexo.setAdapter(adap_sexo);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularCal();
            }
        });
    }

    private void calcularCal() {

        double cal_diarias=0.0;
        double altura_f=0.0, peso_f=0.0;
        int edad_f=0;
        String peso=lbl_peso.getText().toString();
        String altura=lbl_altura.getText().toString();
        String edad=lbl_edad.getText().toString();
        String sex_sel=sp_sexo.getSelectedItem().toString();

        if(!altura.equals("") && !peso.equals("") && !edad.equals("") && (!sex_sel.equals("H") || !sex_sel.equals("M"))) {

            peso_f=Double.parseDouble(peso);
            altura_f=Double.parseDouble(altura);
            edad_f=Integer.parseInt(edad);

            if(sex_sel.equals("H")) {
                cal_diarias=66.0 + (13.7 * peso_f) + (5 * altura_f) - (6.75 * edad_f); }
            else if (sex_sel.equals("M")){
                cal_diarias=655 + (9.6* peso_f) + (1.8 * altura_f) - (4.7 * edad_f); }

        }
        cal_num.setText("0.0/"+String.valueOf(cal_diarias));
    }

}

