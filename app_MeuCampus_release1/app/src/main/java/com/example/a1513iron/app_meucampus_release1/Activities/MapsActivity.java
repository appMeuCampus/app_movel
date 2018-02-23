package com.example.a1513iron.app_meucampus_release1.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.a1513iron.app_meucampus_release1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
    private List<Marker> marcacoes = new ArrayList<Marker>(); //lista de marcações
    private boolean visible = true;
    LocationManager locationManager;
    String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * @param b
     */
    private void setMarkersVisible(boolean b){
        for(int i = 0; i < marcacoes.size(); i++){
            marcacoes.get(i).setVisible(b);
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap; //objeto do tipo googleMap
        mMap.getUiSettings().setMapToolbarEnabled(false); //desativa a MapToolbar
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //tipo do terreno

        //botoes interagíveis do mapa
        final Button botao_satelite = (Button) findViewById(R.id.button_satelite);
        final Button botao_mapa = (Button) findViewById(R.id.button_mapa);
        final ImageButton botao_markers = (ImageButton) findViewById(R.id.imageButtonMarker);

        LatLng foco = new LatLng(-20.033285, -46.010372); //foco de inicio

        //adicionar marcações
        //diretoria de inovação, pesquisa e pós-graduação //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.038060, -46.010859)).title("Diretoria de Inovação, Pesquisa e Pós-Graduação").icon(BitmapDescriptorFactory.defaultMarker(90))));
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03321382, -46.00959045)).title("Restaurante").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))));  //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03354644, -46.00926054)).title("Biblioteca"))); //vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.033179, -46.010261)).title("Poliesportivo").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03341, -46.009998)).title("Diretoria Geral e DAP").icon(BitmapDescriptorFactory.defaultMarker(90)))); //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039247, -46.011195)).title("Prédio da Zootecnia")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.032853, -46.010214)).title("Assistência Estudantil").icon(BitmapDescriptorFactory.defaultMarker(90)))); //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039218, -46.010976)).title("Diretoria de Ensino").icon(BitmapDescriptorFactory.defaultMarker(90)))); //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039147, -46.010714)).title("Salas de Professores"))); //vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03292402, -46.00939465)).title("Secretaria"))); //vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03252084, -46.01010543)).title("Alojamento").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03226632, -46.00909156)).title("Prédio Pedagógico"))); //vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03148262, -46.00848538)).title("Lanchonete").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.0312785, -46.0084371)).title("Academia").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03786552, -46.01063114)).title("Central de Vendas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.03884322, -46.01027977)).title("Lanchonete").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.04053401, -46.01032537)).title("Prédio da Computação")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.04044128,-46.00892687)).title("Laboratórios de Eletrônica")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.033437, -46.010870)).title("Gestão de Pessoas").icon(BitmapDescriptorFactory.defaultMarker(90)))); //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.031472, -46.009033)).title("Centro de Convenções").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.034727, -46.009491)).title("Diretoria de Extensão, Esporte e Cultura").icon(BitmapDescriptorFactory.defaultMarker(90)))); //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039087, -46.010441)).title("Prédio de Laboratórios")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039983, -46.010710)).title("Prédio da Agronomia")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.040251, -46.010337)).title("CGTI").icon(BitmapDescriptorFactory.defaultMarker(90)))); //verde
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.040081, -46.010206)).title("Técnico Integrado Subsequente")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039781, -46.010303)).title("Prédio da Biologia")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039554, -46.010032)).title("Prédio da Engenharia de Produção/Física")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039579, -46.011052)).title("NAE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039273, -46.010234)).title("Auditório 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039056, -46.010088)).title("Almoxarifado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.037610, -46.009630)).title("Prédio da Engenharia de Alimentos")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.037843, -46.009591)).title("Padaria").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.039990, -46.009618)).title("Técnico Integrado e Subsequente")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.030957, -46.008406)).title("Anfiteatro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.030680, -46.008704)).title("Observatório Astronômico").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))); //amarelo
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.040926, -46.009552)).title("Laboratório de Mecânica")));//vermelho
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.037980, -46.010750)).title("Ponto de Ônibus").snippet("Population: 4,137,400")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_busao_mapa))));
        marcacoes.add(mMap.addMarker(new MarkerOptions().position(new LatLng(-20.032399, -46.008709)).title("Ponto de Ônibus").snippet("Population: 4,137,400")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_busao_mapa))));
        //move a camera para enquadrar o foco no IFMG toda vez que abrir o mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLng(foco));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(foco,16));

        //troca o mapa para modo satelite
        botao_satelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        //troca o mapa para modo normal
        botao_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        //coloca os marcadores visíveis ou não
        botao_markers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visible = !visible;
                setMarkersVisible(visible);
            }
        });


        //mostra o rótulo da marcação
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            //se clicar no rótulo abre a activitie "TelaLugarActivity"
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapsActivity.this,TelaLugarActivity.class);

                intent.putExtra("nomeLugar", marker.getTitle());
                startActivity(intent);
            }
        });

    }


    @Override
    public void onLocationChanged(Location localizacaoUsuario) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(localizacaoUsuario.getLatitude(), localizacaoUsuario.getLongitude()), 13));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


}