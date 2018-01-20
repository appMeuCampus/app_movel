package com.example.a1513iron.app_meucampus_release1.Acitivities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.ArrayList;
import java.util.List;

public class ListaNoticiasActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticias);

        CreateDrawerLayout();

        //listview
        ListView listview2 = (ListView) findViewById(R.id.listview2);
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
        final Noticias_Classe n4 = new Noticias_Classe();
        n4.setTitulo("Resultado Preliminar do Processo Seletivo 2018 de alunos regulares do MPSTA");
        n4.setID(4);
        final Noticias_Classe n5 = new Noticias_Classe();
        n5.setTitulo("Alunos do curso de Engenharia de Computação desenvolvem projeto junto à empresa da cidade de Bambuí");
        n5.setID(5);
        final Noticias_Classe n6 = new Noticias_Classe();
        n6.setTitulo("Plantio de árvore simboliza formatura janeiro/2017 dos Cursos Técnicos Integrados - Campus Bambuí");
        n6.setID(6);

        opcoes.add(n1);
        opcoes.add(n2);
        opcoes.add(n3);
        opcoes.add(n4);
        opcoes.add(n5);
        opcoes.add(n6);

        adaptador = new ArrayAdapter<>(ListaNoticiasActivity.this, android.R.layout.simple_list_item_1,opcoes);
        listview2.setAdapter(adaptador);

        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                    case 3:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", n4);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", n5);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", n6);
                        startActivity(intent);
                        break;
                }
            }
        });

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
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
