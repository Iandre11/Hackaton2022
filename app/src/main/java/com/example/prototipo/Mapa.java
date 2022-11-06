package com.example.prototipo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;



import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mapa extends AppCompatActivity  {
    Fragment fragment;
    BottomNavigationView menuNavegacion;
    ImageButton imageButton;


    int puntos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        imageButton = findViewById(R.id.User);





        imageButton.setOnClickListener(view -> {
            Intent intent = new  Intent(this,MainActivity.class);
            startActivity(intent);
        });

        fragment= new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.miframelayout,new Map_Fragment()).commit();
        menuNavegacion=findViewById(R.id.botonNavigationView);
        menuNavegacion.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.bicik:
                    replaceFragment(new Map_Fragment());
                    break;
                case R.id.tramm:
                    replaceFragment(new Map_Fragment2());
                    break;
                case R.id.autob:
                    replaceFragment(new Map_Fragment3());
                    break;

                case R.id.patin:
                    replaceFragment(new Map_Fragment4());
                    break;
                case R.id.HistorialBilletes:
                    replaceFragment(new Fragment_Billetes());

            }
            return true;
        });

    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.miframelayout,fragment);
        fragmentTransaction.commit();
    }


}

