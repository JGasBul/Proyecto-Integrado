package com.example.jesus.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NuevoPersonaje extends AppCompatActivity {

    TextView Daño,Salud,Armadura,Historia,Descripcion;
    Button Aceptar,Atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_personaje);

        Daño = (TextView)findViewById(R.id.Daño);
        Salud = (TextView)findViewById(R.id.Salud);
        Armadura = (TextView)findViewById(R.id.Armadura);
        Historia = (TextView)findViewById(R.id.Historia);
        Descripcion = (TextView)findViewById(R.id.Descripcion);
        Aceptar = (Button) findViewById(R.id.aceptar);
        Atras = (Button) findViewById(R.id.atras);



        //Agafem el bundle que ve amb l'Intent que carrega este activity

        Bundle parametresRebuts = getIntent().getExtras();
        //Agafem els paràmetres del Bundle i els mostrem als TextView corresponents
        Historia.setText(parametresRebuts.getString("Historia"));
        Descripcion.setText(parametresRebuts.getString("Descripcion"));
        Daño.setText(""+parametresRebuts.getInt("Ataque"));
        Salud.setText(""+parametresRebuts.getInt("Salud"));
        Armadura.setText(""+parametresRebuts.getInt("Armadura"));




        Atras.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });


        Aceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });



    }
}
