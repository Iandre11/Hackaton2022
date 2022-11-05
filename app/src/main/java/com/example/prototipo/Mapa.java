package com.example.prototipo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Mapa extends AppCompatActivity  {
    Fragment fragment;
    Button bicicasBoton;
    Button tramBoton;
    Button autobusBoton;
    BottomNavigationView menuNavegacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

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

            }
            return true;
        });


       /* bicicasBoton=findViewById(R.id.buttonBicicas);
        tramBoton=findViewById(R.id.buttonTram);
        autobusBoton=findViewById(R.id.buttonAutobus);

        bicicasBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.buttonBicicas){
                    getSupportFragmentManager().beginTransaction().replace(R.id.miframelayout,new Map_Fragment()).commit();

                }
            }
        });

        tramBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.buttonTram){
                    getSupportFragmentManager().beginTransaction().replace(R.id.miframelayout,new Map_Fragment2()).commit();
                }
            }
        });

        autobusBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.buttonAutobus){
                    getSupportFragmentManager().beginTransaction().replace(R.id.miframelayout,new Map_Fragment3()).commit();
                }
            }
        });
        */

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.miframelayout,fragment);
        fragmentTransaction.commit();
    }


}