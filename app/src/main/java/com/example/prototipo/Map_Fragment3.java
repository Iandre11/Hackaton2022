package com.example.prototipo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class Map_Fragment3 extends Fragment {

    private ArrayList<Autobus> autobusList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_map_3,container,false);


        autobusList=new ArrayList<>();
        autobusList.add(new Autobus(39.9927000,-0.0576700));
        autobusList.add(new Autobus(39.9917000,-0.0576500));
        autobusList.add(new Autobus(39.9907000,-0.0576300));
        autobusList.add(new Autobus(39.9997000,-0.0576200));
        autobusList.add(new Autobus(39.9987000,-0.0576100));
        autobusList.add(new Autobus(39.9937000,-0.0576000));

        autobusList.add(new Autobus(39.9827000,-0.0276700));
        autobusList.add(new Autobus(39.9217000,-0.0176500));
        autobusList.add(new Autobus(39.9107000,-0.0376300));
        autobusList.add(new Autobus(39.9497000,-0.0676200));
        autobusList.add(new Autobus(39.9687000,-0.0976100));
        autobusList.add(new Autobus(39.9937000,-0.0976000));


        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.myFragmento3);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                BitmapDescriptor markerBicicas = BitmapDescriptorFactory.fromResource(R.drawable.iconoautobus);


                LatLng castellon = new LatLng( 39.9929000, -0.0576800);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(castellon));
                googleMap.moveCamera(CameraUpdateFactory.zoomTo(12));


                for(Autobus autobus : autobusList){

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(autobus.getLatitude(),autobus.getLongitude()))
                            .title("autobus")
                            .icon(markerBicicas));
                }

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(latLng.latitude+" kg"+ latLng.longitude);
                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                        googleMap.addMarker(markerOptions);
                    }
                });
            }
        });
        return view;
    }
}