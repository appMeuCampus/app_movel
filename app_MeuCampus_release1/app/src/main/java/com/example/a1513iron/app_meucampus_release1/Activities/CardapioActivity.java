package com.example.a1513iron.app_meucampus_release1.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Cardapio_Classe;
import com.example.a1513iron.app_meucampus_release1.adapter.RecyclerAdapter;


import java.util.ArrayList;
import java.util.List;

public class CardapioActivity extends SobreActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Cardapio_Classe> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        CreateDrawerLayout();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Cardapio_Classe c1 = new Cardapio_Classe();
        c1.setA1("Alface");c1.setA2("Beterraba");c1.setA3("Abóbora");c1.setA4("Arroz Carreteiro");c1.setA5("Feijao");
        c1.setJ1("Alface");c1.setJ2("Beterraba");c1.setJ3("Abóbora");c1.setJ4("Arroz Carreteiro");c1.setJ5("Feijao");
        c1.setDiaDaSemana("segunda-feira");

        Cardapio_Classe c2 = new Cardapio_Classe();
        c2.setA1("Chicória");c2.setA2("Beterraba Cozida");c2.setA3("Costelinha");c2.setA4("Mandioca");c2.setA5("Arroz");c2.setA6("Feijão");
        c2.setJ1("Chicória");c2.setJ2("Beterraba Cozida");c2.setJ3("Costelinh");c2.setJ4("Mandioca");c2.setJ5("Feijao");c2.setJ6("Arroz");
        c2.setDiaDaSemana("terça-feira");

        Cardapio_Classe c3 = new Cardapio_Classe();
        c3.setDiaDaSemana("quarta-feira");

        Cardapio_Classe c4 = new Cardapio_Classe();
        c4.setDiaDaSemana("quinta-feira");

        Cardapio_Classe c5 = new Cardapio_Classe();
        c5.setDiaDaSemana("sexta-feira");

        Cardapio_Classe c6 = new Cardapio_Classe();
        c6.setDiaDaSemana("sábado");


        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);

        adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
    }


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

                Intent intent = new Intent(getApplicationContext(), Teste_Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_sobre: {
                Toast.makeText(this, "Menu Teste", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(intent);
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
