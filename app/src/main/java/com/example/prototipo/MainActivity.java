package com.example.prototipo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView setViewRegister;
    TextInputEditText textInputEmail;
    TextInputEditText textInputPassword;
    Button btnLogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewRegister = findViewById(R.id.textViewRegister);
        textInputEmail = findViewById(R.id.etEmail);
        textInputPassword = findViewById(R.id.etPassw);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(view -> {
            login();      
        });

        setViewRegister.setOnClickListener(view -> {
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
        });

    }

    private void login() {

        String email = textInputEmail.getText().toString();
        String password = textInputPassword.getText().toString();

        if(!email.isEmpty() && !password.isEmpty()) {

            Intent miIntent = new Intent(this, Mapa.class);
            startActivity(miIntent);
        }
        else{
            Toast.makeText(this,"Inserte todos los campos",Toast.LENGTH_LONG).show();
        }

    }
}