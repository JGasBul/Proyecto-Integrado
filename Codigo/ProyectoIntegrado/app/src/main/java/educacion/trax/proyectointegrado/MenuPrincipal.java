package educacion.trax.proyectointegrado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle data = getIntent().getExtras();

        ArrayList personajes = data.getParcelableArrayList("personajes");





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }
}
