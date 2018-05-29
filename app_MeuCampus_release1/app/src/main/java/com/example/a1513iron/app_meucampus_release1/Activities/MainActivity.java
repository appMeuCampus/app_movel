package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objNoticia;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

import org.json.JSONException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Toolbar_Classe{

    public Noticias_Classe ntc = new Noticias_Classe();
    private ListView listview1;
    private List<Noticias_Classe> opcoes;
    private ArrayAdapter<Noticias_Classe> adaptador;
    private  RecuperaDados recd;
    public static final String URL_ACT = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Feed");
        CreateDrawerLayout();

        //lista de noticias
        listview1 = (ListView) findViewById(R.id.listview1);
        opcoes = new ArrayList<>();

        recd = new RecuperaDados(URL_ACT, "BuscarPorIndex",0);
        //recd.execute();

        adaptador = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, opcoes);
        listview1.setAdapter(adaptador);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            Intent intent = new Intent(getApplicationContext(), MostrarNoticiaActivity.class);
                            Log.i("iddddd", Integer.toString(opcoes.get(0).getID()));
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
            //cardview do cardapio_old, pegando o dia da semana
            TextView diaSemana = (TextView) findViewById(R.id.dia_da_semana);
            Locale local = new Locale("pt", "BR");
            DateFormat df = new SimpleDateFormat("EEEE", local);
            Date d = new Date();
            diaSemana.setText(df.format(d));

    }

    public class RecuperaDados extends AsyncTask<Void, Void, ArrayList<Noticias_Classe>> {

        private ProgressDialog load;
        private int num;
        public String titulo;
        public int id;
        String operacao;
        String endereco; //"http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias"

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
        protected ArrayList<Noticias_Classe> doInBackground(Void... params) {
            Utils_objNoticia util = new Utils_objNoticia();
            try {
                return util.getInformacaoNoticias(endereco,operacao, num);
            } catch (JSONException e) {
                e.printStackTrace();
                ArrayList<Noticias_Classe> listaNoticias = new ArrayList<Noticias_Classe>();
                Noticias_Classe noticia = new Noticias_Classe();
                noticia.setTitulo("Erro na conexão com o servidor!");
                noticia.setID(-3);
                listaNoticias.add(noticia);
                return listaNoticias;
            }

        }

        @Override
        protected void onPostExecute(ArrayList<Noticias_Classe> listaNoticias) {

            if(listaNoticias.size() > 1) {
                opcoes.add(listaNoticias.get(0));
                opcoes.add(listaNoticias.get(1));
                opcoes.add(listaNoticias.get(2));
            }else{
                opcoes.add(listaNoticias.get(0));
                opcoes.add(listaNoticias.get(0));
                opcoes.add(listaNoticias.get(0));
            }
            load.dismiss();
            recd = null;

        }

    }
}
