package educacion.trax.proyectointegrado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import educacion.trax.proyectointegrado.Clases.Personaje;

public class Elegir_Personaje extends AppCompatActivity  {
    private FirebaseAuth mAuth;
    private DatabaseReference bbdd, bbdd2;
    private RecyclerView rv;
    private RecyclerView.LayoutManager rvLM;
    private RecyclerView.Adapter aRV;
    ArrayList<Personaje> parray;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parray = new ArrayList<Personaje>();
        setContentView(R.layout.activity_elegir__personaje);
        mAuth = FirebaseAuth.getInstance();
        bbdd = FirebaseDatabase.getInstance().getReference("Usuarios");
        rv = findViewById(R.id.elegirP);
        rvLM = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(rvLM);
        llenarArray();

    }

    private void llenarArray() {


        FirebaseUser user = mAuth.getCurrentUser();
        final String keyuser = user.getUid();
        Query q = bbdd.orderByKey().equalTo(keyuser);
        bbdd2 = FirebaseDatabase.getInstance().getReference("Usuarios");
        //bbdd2.child("usuarios").child("Personajes");
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Query q2 = ds.getRef().child("Personajes").orderByKey();
                    q2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Personaje p = ds.getValue(Personaje.class);
                                parray.add(p);
                            }
                            aRV = new Adaptador_Elegir_Personaje(parray, new Adaptador_Nuevo_Personaje.clickInterface() {
                                @Override
                                public void inf(final Personaje clase) {
                                    final AlertDialog.Builder builder = new AlertDialog.Builder(Elegir_Personaje.this);
                                    LayoutInflater inflater = getLayoutInflater();
                                    View layout = inflater.inflate(R.layout.historia_personaje, null);

                                    final TextView nom = layout.findViewById(R.id.nombre);
                                    nom.setVisibility(View.INVISIBLE);

                                    final TextView nomTxt=layout.findViewById(R.id.nomtxt);
                                    nomTxt.setText(clase.getNombre());
                                    nomTxt.setVisibility(View.VISIBLE);

                                    final TextView clasely = layout.findViewById(R.id.clase);
                                    clasely.setText(clase.getClase());

                                    final TextView ataque = layout.findViewById(R.id.ataque);
                                    ataque.setText(String.valueOf(clase.getDaño()));

                                    final TextView defensa = layout.findViewById(R.id.defensa);
                                    defensa.setText(String.valueOf(clase.getArmadura()));

                                    builder.setView(layout);
                                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(Elegir_Personaje.this,menu_Arena.class);
                                            Bundle b=new Bundle();
                                            b.putParcelable("personaje",clase);
                                            i.putExtras(b);
                                            startActivity(i);
                                        }
                                    }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });
                                    builder.show();
                                    builder.create();
                                }
                            });
                            rv.setAdapter(aRV);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}




