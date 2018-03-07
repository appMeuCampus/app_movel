package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.Teste.Utils;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public Noticias_Classe ntc = new Noticias_Classe();
    private ListView listview1;
    private List<Noticias_Classe> opcoes;
    private ArrayAdapter<Noticias_Classe> adaptador;
    private  RecuperaDados recd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateDrawerLayout();

        //lista de noticias
        listview1 = (ListView) findViewById(R.id.listview1);
        opcoes = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            recd = new RecuperaDados("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias", "BuscarPorIndex", i);
            recd.execute();
        }


        adaptador = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,opcoes);
        listview1.setAdapter(adaptador);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        Log.i("iddddd",Integer.toString(opcoes.get(0).getID()));
                        intent.putExtra("Noticia", opcoes.get(0));
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", opcoes.get(1));
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                        intent.putExtra("Noticia", opcoes.get(2));
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
    public class RecuperaDados extends AsyncTask<Void, Void, Noticias_Classe> {

        private ProgressDialog load;
        private int num;
        public String titulo;
        public int id;
        String operacao;
        String endereco; //"http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias"
        // por default o endereco vai ser esse pois estava craashando o app se deixasse vazio...
        // mas isso não irá interferir nas demais funções da classe pois é umavariavel q muda toda x q um método de busca é chamado


        public RecuperaDados(String url, String operacao,int num){
            this.endereco = url;
            this.operacao = operacao;
            this.num = num;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Noticias_Classe doInBackground(Void... params) {
            Utils util = new Utils();
            try {
                return util.getInformacaoNoticias(endereco,operacao, num);
            } catch (JSONException e) {
                e.printStackTrace();
                Noticias_Classe noticia = new Noticias_Classe();
                noticia.setTitulo("Erro na conexão com o servidor!");
                noticia.setID(-3);
                return noticia;
            }

        }

        @Override
        protected void onPostExecute(Noticias_Classe noticiaa) {

            opcoes.add(noticiaa);
            load.dismiss();

        }

    }
}
