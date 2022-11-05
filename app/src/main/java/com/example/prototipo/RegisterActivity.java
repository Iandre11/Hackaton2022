package com.example.prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    Button botonVolver ;
    TextInputEditText username;
    TextInputEditText emailRegister;
    TextInputEditText passwordRegister;
    TextInputEditText confirmpasswordRegister;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        emailRegister = findViewById(R.id.email);
        passwordRegister = findViewById(R.id.firstPass);
        confirmpasswordRegister =findViewById(R.id.confirmPassw);
        btnRegister = findViewById(R.id.btnRegister);
        botonVolver = findViewById(R.id.btnBack);





        btnRegister.setOnClickListener(view -> {
                         register();
        });


        botonVolver.setOnClickListener(view -> {
            finish();
        });
    }

    private void register() {
        String usuario = username.getText().toString();
        String email = emailRegister.getText().toString();
        String password = passwordRegister.getText().toString();
        String confirmPassword = confirmpasswordRegister.getText().toString();

        if(!usuario.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            if(isEmailValid(email)){
                Toast.makeText(this,"Has insertado todos los campos",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"El email no es valido",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"Inserte todos los campos requeridos",Toast.LENGTH_LONG).show();
        }

    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}