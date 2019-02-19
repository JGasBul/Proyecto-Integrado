package com.example.jesus.prueba;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MLuchaTienda extends AppCompatActivity implements MLuchaFragment.OnFragmentInteractionListener,MTiendaFragment.OnFragmentInteractionListener {


    private FragmentTransaction ft1, ft2;
    private MLuchaFragment fML;
    private FragmentManager fm;
    private MTiendaFragment fMT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_lucha_tienda);

        fm=getSupportFragmentManager();

        fML = MLuchaFragment.newInstance(1,2);
        ft1=fm.beginTransaction();
        ft1.add(R.id.fragment_lucha,fML);
        ft1.commit();

        fm=getSupportFragmentManager();

        fMT = MTiendaFragment.newInstance(1);
        ft2=fm.beginTransaction();
        ft2.add(R.id.fragment_tienda,fMT);
        ft2.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
