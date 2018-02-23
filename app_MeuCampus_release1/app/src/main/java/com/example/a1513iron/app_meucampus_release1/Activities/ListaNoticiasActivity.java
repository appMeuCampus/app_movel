package com.example.a1513iron.app_meucampus_release1.Activities;

import android.content.Context;
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
import com.example.a1513iron.app_meucampus_release1.Teste.GetJSON_Classe;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListaNoticiasActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Noticias_Classe> noticia = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticias);

        CreateDrawerLayout();

        //listview
        ListView listview2 = (ListView) findViewById(R.id.listview2);
        ArrayAdapter<Noticias_Classe> adaptador;
        GetJSON_Classe aux = new GetJSON_Classe();


        try {
            int numeroNoticias = aux.GetNumeroNoticias();
            aux = new GetJSON_Classe();
            if(numeroNoticias < 6){
                Context context = getApplicationContext();
                CharSequence text = "numero de noticias menor que o esperado";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

            for(int i = 0; i < 6; i++){
                    noticia.add(aux.BuscarNoticiaPorIndex(i));

                aux = new GetJSON_Classe();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<>(ListaNoticiasActivity.this, android.R.layout.simple_list_item_1,noticia);
        listview2.setAdapter(adaptador);

        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", noticia.get(0));
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", noticia.get(1));
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", noticia.get(2));
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", noticia.get(3));
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", noticia.get(4));
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", noticia.get(5));
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
