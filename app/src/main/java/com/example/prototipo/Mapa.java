package com.example.prototipo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class Mapa extends AppCompatActivity  {
    Fragment fragment;
    BottomNavigationView menuNavegacion;
    ImageButton imageButton;

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

                case R.id.imageViewBilletes:
                    replaceFragment(new Billetes_Fragment());

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