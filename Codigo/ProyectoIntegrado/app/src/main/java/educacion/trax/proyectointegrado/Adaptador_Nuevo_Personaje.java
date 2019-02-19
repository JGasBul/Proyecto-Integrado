package educacion.trax.proyectointegrado;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import educacion.trax.proyectointegrado.Clases.Personaje;

/**
 * Created by Pepeg on 12/02/2019.
 */

public class Adaptador_Nuevo_Personaje extends RecyclerView.Adapter<Adaptador_Nuevo_Personaje.Holder> {
    private ArrayList<Personaje> personajes;
    private clickInterface mcomunicador;

    public Adaptador_Nuevo_Personaje(ArrayList<Personaje> personajes,clickInterface mcomunicador) {
        this.personajes = personajes;
        this.mcomunicador=mcomunicador;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nom;
        public ImageView img;
        clickInterface comunicador;
        public Holder(View itemView,clickInterface comunicador) {
            super(itemView);
            nom=itemView.findViewById(R.id.nom);
            nom.setOnClickListener(this);
            img=itemView.findViewById(R.id.imageView);
            img.setOnClickListener(this);
            this.comunicador=comunicador;
        }

        @Override
        public void onClick(View v) {
            Personaje p=personajes.get(getAdapterPosition());
            if (v.getId()==R.id.nom){
                comunicador.inf(p);
            }
            if (v.getId()==R.id.imageView){
                comunicador.inf(p);
            }
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_personajenuevo,parent,false);
        return new Holder(v,mcomunicador);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.nom.setText(personajes.get(position).getClase());
    }

    @Override
    public int getItemCount() {
        return this.personajes.size();
    }

    public interface clickInterface{
        void inf(Personaje clase);
    }

}
