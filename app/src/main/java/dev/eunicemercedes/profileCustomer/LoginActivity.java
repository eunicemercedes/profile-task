package dev.eunicemercedes.profileCustomer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Customers.initCustomer();
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validar();
            }
        });
    }

    public void validar() {
        EditText emailEditText = findViewById(R.id.emailLogin);
        EditText passwordEditText = findViewById(R.id.passwordLogin);

        //validar que no esten vacios
        if (emailEditText.getText().length() == 0) {
            mostrarMensaje("Debe escribir email");
        } else if (passwordEditText.getText().length() == 0) {
            mostrarMensaje("Debe escribir contrasena");
        }
        //validar que el email exista
        else if (!(Customers.existsEmail(emailEditText.getText().toString()))) {
            mostrarMensaje("No existe email");
        }

        //validar contrasena

        else {
            Customer customer = Customers.validateCustomer(emailEditText.getText().toString(), passwordEditText.getText().toString());
            if (customer.getEmail() != "") {
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("EMAIL", customer.getEmail());
                intent.putExtra("PASSWORD", customer.getPassword());
                mostrarMensaje("Bienvenido " + customer.getNombre());
                passwordEditText.setText("");
                emailEditText.setText("");
                startActivity(intent);
            } else {
                mostrarMensaje("Contrasena incorrecta");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}

