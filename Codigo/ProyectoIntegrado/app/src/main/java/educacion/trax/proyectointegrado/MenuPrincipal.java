package educacion.trax.proyectointegrado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {
    Button botonJugar,botonNuevaPartida,botonOpciones,botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        botonJugar = (Button)findViewById(R.id.buttonJugar);
        botonOpciones=(Button)findViewById(R.id.buttonOpciones);
        botonSalir=(Button)findViewById(R.id.buttonSalirMenuPrincipal);
        botonNuevaPartida=(Button)findViewById(R.id.buttonNuevaPartida);

        botonJugar.setOnClickListener(this);
        botonOpciones.setOnClickListener(this);
        botonSalir.setOnClickListener(this);
        botonNuevaPartida.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        if (v.getId()==R.id.buttonJugar){
            i = new Intent(this,NuevoPersonaje.class);
        }
        if (v.getId()==R.id.buttonNuevaPartida){
            i = new Intent();
        }
        if (v.getId()==R.id.buttonOpciones){
            i = new Intent();
        }
        if (v.getId()==R.id.buttonNuevaPartida){
            i = new Intent();
        }
/*
        if(v.getId()==botonJugar.getId()){
            i = new Intent();
        }else if(v.getId()==botonNuevaPartida.getId()){
            i = new Intent();
        }else if(v.getId()==botonOpciones.getId()){
            i = new Intent();


        }else if(v.getId()==botonSalir.getId()){
            finish();
        }
        */
    }
}
