package com.example.a1513iron.app_meucampus_release1.Acitivities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.GetJSON_Classe;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.concurrent.ExecutionException;

public class MostrarNoticiaActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticia);

        CreateDrawerLayout();

        TextView tituloAtual = (TextView) findViewById(R.id.textviewTituloAtual);
        TextView textoAtual = (TextView) findViewById(R.id.textviewTextoAtual);

        //recuperando os dados passado da activity que chamou essa activity
        Intent it = getIntent();
        Noticias_Classe noticiaAtual = it.getParcelableExtra("Noticia");

        if(noticiaAtual != null){
                tituloAtual.setText(noticiaAtual.getTitulo());

                GetJSON_Classe aux = new GetJSON_Classe();
                String texto = "vazio";
            try {
                texto = aux.BuscarTextodeNoticia(noticiaAtual.getID());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textoAtual.setText(texto);

        }else{
            tituloAtual.setText("vazio");
            textoAtual.setText("vazio");
        }

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
