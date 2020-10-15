package co.edu.ufps.seiiis2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrarActivity extends AppCompatActivity {
    TextView nuevoUsuario;
    TextInputLayout nuevoEmail, nuevaClave;
    MaterialButton registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nuevoEmail = findViewById(R.id.nuevoEmail);
        nuevaClave = findViewById(R.id.nuevoClave);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);
        registrar = findViewById(R.id.registrar);
    }
}