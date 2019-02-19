package educacion.trax.proyectointegrado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import educacion.trax.proyectointegrado.Clases.Personaje;
import educacion.trax.proyectointegrado.Clases.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private DatabaseReference bbdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        final Button login=findViewById(R.id.login);
        login.setOnClickListener(this);
        final Button register=findViewById(R.id.register);
        register.setOnClickListener(this);
        bbdd= FirebaseDatabase.getInstance().getReference("Usuarios");
    }



    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.register){
            final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            LayoutInflater inflater = getLayoutInflater();
            View layout=inflater.inflate(R.layout.register, null);
            builder.setView(layout);
            final EditText txtNombre = (EditText) layout.findViewById(R.id.nom);
            final EditText txtContraseña=(EditText) layout.findViewById(R.id.con);
            final EditText txtEmail=layout.findViewById(R.id.email);

            builder.setPositiveButton("Aceptaer", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    crearCuenta(txtNombre.getText().toString().trim(),txtContraseña.getText().toString().trim(),txtEmail.getText().toString().trim());
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
            builder.create();
        }
        if (v.getId()==R.id.login){
            final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            LayoutInflater inflater = getLayoutInflater();
            View layout=inflater.inflate(R.layout.login, null);
            builder.setView(layout);
            final EditText txtContraseña=(EditText) layout.findViewById(R.id.con);
            final EditText txtEmail=layout.findViewById(R.id.email);
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   login(txtEmail.getText().toString().trim(),txtContraseña.getText().toString().trim());
                }
            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
            builder.create();
        }
    }

    private void login(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i=new Intent(MainActivity.this,MenuPrincipal.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private void crearCuenta(final String nom, String contr, final String email) {
        mAuth.createUserWithEmailAndPassword(email, contr)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Usuario usuario=new Usuario(email,nom);
                            Toast.makeText(MainActivity.this, "Creación Correcta.",
                                    Toast.LENGTH_SHORT).show();
                            String key= user.getUid();
                           bbdd.child(key).setValue(usuario);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Ha habido un error, compruebe que ha introducido los datos correctamente.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
