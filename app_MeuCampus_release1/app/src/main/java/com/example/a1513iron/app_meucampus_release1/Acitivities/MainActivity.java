package com.example.a1513iron.app_meucampus_release1.Acitivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.TesteWebServiceActivity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateDrawerLayout();

        //lista de noticias
        ListView listview1 = (ListView) findViewById(R.id.listview1);
        List<Noticias_Classe> opcoes = new ArrayList<>();
        ArrayAdapter<Noticias_Classe> adaptador;

        final Noticias_Classe n1 = new Noticias_Classe();
        n1.setTitulo("Está aberto o período de SOLICITAÇÃO DA RENOVAÇÃO DE MATRÍCULA");
        n1.setID(1);
        final Noticias_Classe n2 = new Noticias_Classe();
        n2.setTitulo("Alunos dos cursos de Licenciatura de Bambuí ganham prêmio no VI Encontro do PIBID IFMG");
        n2.setID(2);
        final Noticias_Classe n3 = new Noticias_Classe();
        n3.setTitulo("Novo servidor passa a integrar a equipe do IFMG - Campus Bambuí");
        n3.setID(3);

        opcoes.add(n1);
        opcoes.add(n2);
        opcoes.add(n3);

        adaptador = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,opcoes);
        listview1.setAdapter(adaptador);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", n1);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", n2);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", n3);
                        startActivity(intent);
                        break;
                }
            }
        });
        //cardview do cardapio, pegando o dia da semana
        TextView diaSemana = (TextView) findViewById(R.id.dia_da_semana);
        Locale local = new Locale("pt", "BR");
        DateFormat df = new SimpleDateFormat("EEEE", local);
        Date d = new Date();
        diaSemana.setText(df.format(d));

    }

    public void CreateDrawerLayout(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.cloe_drawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    //botao de voltar não fecha o app
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    //maquina de estados dos menus do drawerLayout
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {

            case R.id.menu_meucampus: {
                Toast.makeText(this, "Menu MeuCampus", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.menu_noticias: {
                Toast.makeText(this, "Menu Noticias", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListaNoticiasActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_cardapio: {
                Toast.makeText(this, "Menu Cardapio", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CardapioActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_busao: {
                Toast.makeText(this, "Menu Busão", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_mapa: {
                Toast.makeText(this, "Menu Mapa", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_teste: {
                Toast.makeText(this, "Menu Teste", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), TesteWebServiceActivity.class);
                startActivity(intent);
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
