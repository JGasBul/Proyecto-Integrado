package com.example.jesus.prueba;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.AccessControlContext;
import java.util.ArrayList;


public class AdaptadorClases extends RecyclerView.Adapter<AdaptadorClases.ElWievHolder> {

    public static AccessControlContext context;
    public NotificaAccions comunicador;



    public interface NotificaAccions {
        void onClick(String nom, String desc, String hist, int atq, int sld, int arm);


    }
    ArrayList<Clases> llistatClases;
    public AdaptadorClases(ArrayList<Clases> llista){
        llistatClases = llista;
    }

    public static class ElWievHolder extends RecyclerView.ViewHolder{

        TextView clase;
        LinearLayout lnl;



        public ElWievHolder(View itemView) {
            super(itemView);
            clase = (TextView) itemView.findViewById(R.id.clase);


            lnl = (LinearLayout) itemView.findViewById(R.id.lnl);

        }



    }


    @Override
    public ElWievHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_clases, parent, false);
        return new ElWievHolder(v);

    }

    public AdaptadorClases(ArrayList<Clases> llistat_Clases, AccessControlContext cont, NotificaAccions na) {

        context = cont;
        llistatClases = llistat_Clases;
        comunicador = na;

    }

    @Override
    public void onBindViewHolder(ElWievHolder holder, final int i) {
        holder.clase.setText(llistatClases.get(i).getNombre());


        holder.clase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicador.onClick(llistatClases.get(i).getNombre(),
                        llistatClases.get(i).getDesc(),llistatClases.get(i).getHist(),llistatClases.get(i).getAtq(),
                        llistatClases.get(i).getSld(),llistatClases.get(i).getArm());
            }
        });

    }

    @Override
    public int getItemCount() {
        return llistatClases.size();
    }








}

