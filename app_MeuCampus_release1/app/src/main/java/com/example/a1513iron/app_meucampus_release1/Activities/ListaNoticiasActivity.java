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
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objNoticia;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.adapter.RecyclerAdapterNoticias;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ListaNoticiasActivity extends Toolbar_Classe {

    //private RecyclerView recyclerView;
    //private RecyclerAdapterNoticias adapter;
    private List<Noticias_Classe> list = new ArrayList<>();
    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;
    private RecuperaDados recd;
    //public static final String URL_ACT = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";
    public static final String URL_ACT = "http://app.bambui.ifmg.edu.br/integracao/noticia/retornarNoticias";
    private static class ViewHolder{
        RecyclerView recyclerNoticias;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticias);

        this.mContext = this;

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Notícias");
        CreateDrawerLayout();

        //obter o recycler
        this.mViewHolder.recyclerNoticias = (RecyclerView) this.findViewById(R.id.recycler_view2);

        //definir o layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerNoticias.setLayoutManager(linearLayoutManager);

        recd = new RecuperaDados(URL_ACT, "BuscarPorIndex",0);
        recd.execute();
    }

    // Implementa o evento de click para passar por parâmetro para a ViewHolder
    OnListClickInteractionListener listener = new OnListClickInteractionListener() {
        @Override
        public void onClick(Noticias_Classe noticiaa) {
            Intent intent = new Intent(mContext, MostrarNoticiaActivity.class);
            intent.putExtra("Noticia", noticiaa);
            startActivity(intent);
        }

        @Override
        public void onClick(Eventos_Classe noticiaa) {

        }

        @Override
        public void onClick(Integer src, View view) {

        }
    };

    public class RecuperaDados extends AsyncTask<Void, Void, ArrayList<Noticias_Classe>> {

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
            load = ProgressDialog.show(ListaNoticiasActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected ArrayList<Noticias_Classe> doInBackground(Void... params) {
            Utils_objNoticia util = new Utils_objNoticia();
            try {
                return util.getInformacaoNoticias(endereco,operacao, num);
            } catch (JSONException e) {
                e.printStackTrace();
                Noticias_Classe noticia = new Noticias_Classe();
                noticia.setTitulo("Erro na conexão com o servidor!");
                noticia.setID(-3);
                ArrayList<Noticias_Classe> listaNoticias = new ArrayList<Noticias_Classe>();
                return listaNoticias;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Noticias_Classe> listaNoticias) {
            for(int i = 0; i < listaNoticias.size();i++){
                list.add(listaNoticias.get(i));
            }
            //definir o adapter
            RecyclerAdapterNoticias noticiaAdapter = new RecyclerAdapterNoticias(list,listener);
            mViewHolder.recyclerNoticias.setAdapter(noticiaAdapter);
            load.dismiss();
        }
    }
}
