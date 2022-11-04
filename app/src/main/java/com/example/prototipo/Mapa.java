package com.example.prototipo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class Mapa extends AppCompatActivity {
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.miframelayout,fragment).commit();

    }
}