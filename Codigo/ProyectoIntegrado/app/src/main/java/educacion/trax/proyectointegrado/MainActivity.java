package educacion.trax.proyectointegrado;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import educacion.trax.proyectointegrado.clases.Personaje;

public class MainActivity extends AppCompatActivity {
    Button botonSiguiente, botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonSiguiente = findViewById(R.id.buttonEmpezar);
        botonSalir=findViewById(R.id.buttonSalirActivityMain);

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MenuPrincipal.class);
                ArrayList<Personaje> personajesArray = new ArrayList<Personaje>();

                Personaje pers1 = new Personaje("FelipeV","Warrior");

                personajesArray.add(pers1);

                i.putParcelableArrayListExtra("personajes",personajesArray);
                startActivity(i);

            }
        });
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
