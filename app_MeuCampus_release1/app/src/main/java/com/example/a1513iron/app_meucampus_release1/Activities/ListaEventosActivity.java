package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objEventos;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.adapter.RecyclerAdapterEventos;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ListaEventosActivity extends SobreActivity implements NavigationView.OnNavigationItemSelectedListener {

    private List<Eventos_Classe> list = new ArrayList<>();
    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;
    private RecuperaDados recd;
    //public static final String URL_ACT = "http://10.0.2.2/appmeucampus/integracao/evento/retornarEventos";
    public static final String URL_ACT = "http://app.bambui.ifmg.edu.br/integracao/evento/retornarEventos";
    private static class ViewHolder{
        RecyclerView recyclerEventos;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);

        this.mContext = this;
        CreateDrawerLayout();

        //obter o recycler
        this.mViewHolder.recyclerEventos = (RecyclerView) this.findViewById(R.id.recycler_view_eventos);

        //definir o layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerEventos.setLayoutManager(linearLayoutManager);

        recd = new RecuperaDados(URL_ACT, "BuscarPorIndex",0);
        recd.execute();

    }

    // Implementa o evento de click para passar por parâmetro para a ViewHolder
    OnListClickInteractionListener listener = new OnListClickInteractionListener() {
        @Override
        public void onClick(Noticias_Classe noticiaa) {
        }

        @Override
        public void onClick(Eventos_Classe eventoo) {
            System.out.println(eventoo.getData_inicial());
            Intent intent = new Intent(mContext, MostrarEventoActivity.class);
            System.out.println("nome: " + eventoo.getNome() + " data: " + eventoo.getData_inicial());
            intent.putExtra("Evento", eventoo);
            startActivity(intent);
        }
    };

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
            load = ProgressDialog.show(ListaEventosActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
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
            for(int i = 0; i < listaEventos.size();i++){
                list.add(listaEventos.get(i));
            }
            //definir o adapter
            RecyclerAdapterEventos eventoAdapter = new RecyclerAdapterEventos(list,listener);
            mViewHolder.recyclerEventos.setAdapter(eventoAdapter);
            load.dismiss();
        }
    }
}
