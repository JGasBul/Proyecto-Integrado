package educacion.trax.proyectointegrado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {
   private Button botonJugar,botonNuevaPartida,botonOpciones,botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        botonJugar = (Button)findViewById(R.id.buttonJugar);
        botonJugar.setOnClickListener(this);
        botonOpciones=(Button)findViewById(R.id.buttonOpciones);
        botonOpciones.setOnClickListener(this);
        botonSalir=(Button)findViewById(R.id.buttonSalirMenuPrincipal);
        botonSalir.setOnClickListener(this);
        botonNuevaPartida=(Button)findViewById(R.id.buttonNuevaPartida);
        botonNuevaPartida.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        if (v.getId()==R.id.buttonJugar){
            i = new Intent(this,Elegir_Personaje.class);
            startActivity(i);

        }
        if (v.getId()==R.id.buttonNuevaPartida){
            i = new Intent(this,NuevoPersonaje.class);
            startActivity(i);
        }
        if (v.getId()==R.id.buttonOpciones){
            i = new Intent();
        }
        if (v.getId()==R.id.buttonSalirMenuPrincipal){
            finishAffinity();
            System.exit(0);
        }
    }
}
