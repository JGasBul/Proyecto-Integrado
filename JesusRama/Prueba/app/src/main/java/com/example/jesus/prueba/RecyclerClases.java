package com.example.jesus.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;
public class RecyclerClases extends AppCompatActivity {

    ArrayList<Clases> llistat_Clases;
    RecyclerView rv;
    LinearLayoutManager lm;
    AdaptadorClases emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_clases);

        llistat_Clases= new ArrayList<Clases>();

        asignarDatos();
        rv = (RecyclerView)findViewById(R.id.rv);
        lm = new GridLayoutManager(getApplicationContext(),1);
        rv.setLayoutManager(lm);
        emp = new AdaptadorClases(llistat_Clases, getContext(), new AdaptadorClases.NotificaAccions() {

            @Override
            public void onClick(String nom, String desc, String hist, int atq, int sld, int arm) {

                if (nom=="Tank"){


                    Intent i = new Intent(getApplicationContext(),NuevoPersonaje.class);

                    Bundle b = new Bundle();




                    b.putString("Descripcion",desc);
                    b.putString("Historia",hist);
                    b.putInt("Ataque",atq);
                    b.putInt("Salud",sld);
                    b.putInt("Armadura",arm);

                    i.putExtras(b);

                    startActivity(i);



                }
                if (nom=="Warrior"){
                    Intent i = new Intent(getApplicationContext(),NuevoPersonaje.class);

                    Bundle b = new Bundle();




                    b.putString("Descripcion",desc);
                    b.putString("Historia",hist);
                    b.putInt("Ataque",atq);
                    b.putInt("Salud",sld);
                    b.putInt("Armadura",arm);

                    i.putExtras(b);

                    startActivity(i);



                }
                if (nom=="Rogue"){
                    Intent i = new Intent(getApplicationContext(),NuevoPersonaje.class);

                    Bundle b = new Bundle();




                    b.putString("Descripcion",desc);
                    b.putString("Historia",hist);
                    b.putInt("Ataque",atq);
                    b.putInt("Salud",sld);
                    b.putInt("Armadura",arm);

                    i.putExtras(b);

                    startActivity(i);



                }


            }
        });



        rv.setAdapter(emp);


    }

    public void asignarDatos(){
        Clases c;


        c = new Clases("Tank","Superior","Animació d'activitats físiques i esportives",80,100,100);
        llistat_Clases.add(c);
        c = new Clases("Warrior","Mitjà","Conducción de actividades físico deportivas en el medio natural",100,100,100);
        llistat_Clases.add(c);
        c = new Clases("Rogue","Superior","Gestión de Ventas y Espacios Comerciales",120,80, 100);
        llistat_Clases.add(c);

    }

}
