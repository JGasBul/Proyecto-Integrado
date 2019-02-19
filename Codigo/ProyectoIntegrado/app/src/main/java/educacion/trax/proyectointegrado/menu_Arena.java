package educacion.trax.proyectointegrado;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import educacion.trax.proyectointegrado.Clases.Personaje;
import educacion.trax.proyectointegrado.fragments.entrar_tienda;
import educacion.trax.proyectointegrado.fragments.jugar_arena;

public class menu_Arena extends AppCompatActivity implements jugar_arena.OnFragmentInteractionListener,entrar_tienda.OnFragmentInteractionListener{
    private FragmentTransaction ft1, ft2;
    private jugar_arena fML;
    private entrar_tienda fmt;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__arena);
        Bundle b=getIntent().getExtras();
        Personaje p=b.getParcelable("personaje");
        fm=getFragmentManager();
        fML = jugar_arena.newInstance(p);
        ft1=fm.beginTransaction();
        ft1.replace(R.id.juego,fML);
        ft1.commit();
        fmt=entrar_tienda.newInstance(p);
        ft2=fm.beginTransaction();
        ft2.replace(R.id.tienda,fmt);
        ft2.commit();


       /* fa=jugar_arena.newInstance(p);
        ft=fm.beginTransaction();
        ft.replace(R.id.battle,fa);
        ft.commit();
        */

    }

    @Override
    public void aceptar(Personaje p) {
        Intent i = new Intent(menu_Arena.this,battle.class);
        Bundle b=new Bundle();
        b.putParcelable("personaje",p);
        i.putExtras(b);
        startActivity(i);
    }

    @Override
    public void tienda(Personaje p) {
        Intent i = new Intent(menu_Arena.this,tienda.class);
        Bundle b=new Bundle();
        b.putParcelable("personaje",p);
        i.putExtras(b);
        startActivity(i);
    }
}
