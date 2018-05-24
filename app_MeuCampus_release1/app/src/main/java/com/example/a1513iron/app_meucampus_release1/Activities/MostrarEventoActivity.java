package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objEventos;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;

import org.json.JSONException;

import java.util.ArrayList;

public class MostrarEventoActivity extends SobreActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView nomeEvento;

    private TextView data_inicial;
    private TextView hora_inicio;
    private TextView hora_termino;
    private TextView data_final;
    private TextView descricao;
    private Eventos_Classe eventoAtual;
    private RecuperaDados recd;

    //public static final String URL_ACT = "http://10.0.2.2/appmeucampus/integracao/evento/retornarEvento?id=";
    public static final String URL_ACT = "http://app.bambui.ifmg.edu.br/integracao/evento/retornarEvento?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_evento);

        CreateDrawerLayout();

        nomeEvento = (TextView) findViewById(R.id.textViewNomeEventoAtual);
        hora_inicio = (TextView) findViewById(R.id.textViewHoraInicio);
        hora_termino = (TextView) findViewById(R.id.textViewHoraTermino);
        data_inicial = (TextView) findViewById(R.id.textViewDataInicial);
        data_final = (TextView) findViewById(R.id.textViewDataFinal);
        descricao = (TextView) findViewById(R.id.textViewDescricaoEvento);

        nomeEvento.setText("default");
        hora_inicio.setText("default");
        hora_termino.setText("default");
        data_inicial.setText("default");
        data_final.setText("defaul");
        descricao.setText("default");

        Intent it = getIntent();
        eventoAtual = it.getParcelableExtra("Evento");

        recd = new RecuperaDados(URL_ACT, "BuscarPorID",eventoAtual.getId());
        recd.execute();




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
            case R.id.menu_eventos: {
                Toast.makeText(this, "Menu Evntos", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListaEventosActivity.class);
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
                Intent intent = new Intent(getApplicationContext(),HorarioOnibusActivity.class);
                startActivity(intent);
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

    public class RecuperaDados extends AsyncTask<Void, Void, ArrayList<Eventos_Classe>> {

        private ProgressDialog load;
        private int num;
        String operacao;
        String endereco;

        public RecuperaDados(String url, String operacao, int num) {
            this.endereco = url;
            this.operacao = operacao;
            this.num = num;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MostrarEventoActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected ArrayList<Eventos_Classe> doInBackground(Void... params) {
            Utils_objEventos util = new Utils_objEventos();
            try {
                return util.getInformacaoEventos(endereco, operacao, num);
            } catch (JSONException e) {
                e.printStackTrace();
                ArrayList<Eventos_Classe> eventos = new ArrayList<>();
                eventos.add(new Eventos_Classe());
                return eventos;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Eventos_Classe> listaEventos) {
            nomeEvento.setText(listaEventos.get(0).getNome());
            data_inicial.setText(listaEventos.get(0).getData_inicial());
            data_final.setText(listaEventos.get(0).getData_final());
            descricao.setText(listaEventos.get(0).getDescricao());
            hora_inicio.setText(listaEventos.get(0).getHora_inicio());
            hora_termino.setText(listaEventos.get(0).getHora_termino());
            load.dismiss();
        }
    }
}