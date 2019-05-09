package com.example.trabalhofinal2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.trabalhofinal2.dao.Dao;
import com.example.trabalhofinal2.model.Ponto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Dao dao;

    private MarkerOptions options = new MarkerOptions();
    private ArrayList<LatLng> latlngs = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        dao = new Dao(MapsActivity.this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng ponto = new LatLng(-25.73560254, -53.05798153);
        List<Ponto> pontos = dao.listarPontos();

        for( int i = 0; i < pontos.size(); i++ ){

            Log.i("Carregar Pontos", "Ponto: "+i);
            Log.i("Carregar Pontos", ""+pontos.get(i).getNome() );
            Log.i("Carregar Pontos", "Latitude: "+pontos.get(i).getLatitude() );
            Log.i("Carregar Pontos", "Longitude: "+pontos.get(i).getLongitude() );

            Log.i("Carregar Pontos", "-----");

            ponto = new LatLng(Double.parseDouble( pontos.get(i).getLatitude() ), Double.parseDouble( pontos.get(i).getLongitude() ) );

            mMap.addMarker(new MarkerOptions().position(
                    ponto
            ).title( pontos.get(i).getNome() ));

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(
                ponto
        ));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                ponto, 7));

    }



}
