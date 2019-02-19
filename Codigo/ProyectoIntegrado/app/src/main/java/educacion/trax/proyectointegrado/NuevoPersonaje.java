package educacion.trax.proyectointegrado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

import educacion.trax.proyectointegrado.Clases.Personaje;

public class NuevoPersonaje extends AppCompatActivity implements Adaptador_Nuevo_Personaje.clickInterface{
    private RecyclerView rv;
    private RecyclerView.LayoutManager rvLM;
    private RecyclerView.Adapter aRV;
    private Personaje p0,p1,p2;
    private ArrayList<Personaje> personajes;
    private DatabaseReference bbdd;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personajes=new ArrayList<Personaje>();
        p0=new Personaje(0);
        personajes.add(p0);
        p1=new Personaje(1);
        personajes.add(p1);
        p2=new Personaje(2);
        personajes.add(p2);
        setContentView(R.layout.activity_nuevo_personaje);
        rv=findViewById(R.id.personaje_nuevo);
        rvLM=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(rvLM);
        aRV=new Adaptador_Nuevo_Personaje(personajes,this);
        rv.setAdapter(aRV);
        bbdd= FirebaseDatabase.getInstance().getReference("Usuarios");
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void inf(final Personaje clase) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(NuevoPersonaje.this);
        LayoutInflater inflater = getLayoutInflater();
        View layout=inflater.inflate(R.layout.historia_personaje, null);

        final TextView nom=layout.findViewById(R.id.nombre);
        nom.setVisibility(View.VISIBLE);

        final TextView nomTxt=layout.findViewById(R.id.nomtxt);
        nomTxt.setVisibility(View.INVISIBLE);

        final TextView clasely=layout.findViewById(R.id.clase);
        clasely.setText(clase.getClase());

        final TextView ataque=layout.findViewById(R.id.ataque);
        ataque.setText(String.valueOf(clase.getDaño()));

        final TextView defensa=layout.findViewById(R.id.defensa);
        defensa.setText(String.valueOf(clase.getArmadura()));

        builder.setView(layout);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clase.setNombre(nom.getText().toString());
                push(clase);
                finish();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
        builder.create();
    }

    private void push(final Personaje clase) {
        FirebaseUser user = mAuth.getCurrentUser();
        String keyuser = user.getUid();
        final String key=bbdd.push().getKey();
        Query q=bbdd.orderByKey().equalTo(keyuser);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    bbdd.child(ds.getKey()).child("Personajes").child(key).setValue(clase);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
