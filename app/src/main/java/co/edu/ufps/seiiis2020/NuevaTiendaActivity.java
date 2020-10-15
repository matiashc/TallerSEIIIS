package co.edu.ufps.seiiis2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevaTiendaActivity extends AppCompatActivity {
    private TextInputEditText imagen;
    private TextInputEditText nombre;
    private TextInputEditText descripcion;
    private TextInputEditText telefono;
    private TextInputEditText horario;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tienda);
        imagen = findViewById(R.id.textimagen);
        nombre = findViewById(R.id.textnombre);
        descripcion = findViewById(R.id.textdescripcion);
        telefono = findViewById(R.id.texttelefono);
        horario= findViewById(R.id.texthorario);
        guardar = findViewById(R.id.btguardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });
    }

    private void guardar(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Tienda tienda= new Tienda(myRef.push().getKey(),nombre.getText().toString(),descripcion.getText().toString(),imagen.getText().toString(),telefono.getText().toString(),horario.getText().toString());
        myRef.child("tiendas").child(tienda.getId()).setValue(tienda);
        Toast.makeText(NuevaTiendaActivity.this, "Se almaceno con exito",
                Toast.LENGTH_SHORT).show();
        finish();

    }
}