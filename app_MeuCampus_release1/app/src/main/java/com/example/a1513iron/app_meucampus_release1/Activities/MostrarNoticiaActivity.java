package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objNoticia;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.URLImageParser;
import org.json.JSONException;
import java.util.ArrayList;

public class MostrarNoticiaActivity extends Toolbar_Classe{

    private String texto = "vazio";
    private TextView tituloAtual;
    private WebView wv;
    private Noticias_Classe noticiaAtual;
    public static final String URL_ACT = "http://app.bambui.ifmg.edu.br/integracao/noticia/retornarNoticia?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticia);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Notícias");
        CreateDrawerLayout();

        tituloAtual = (TextView) findViewById(R.id.textviewTituloAtual);
        wv = (WebView) findViewById(R.id.webviewNoticia);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setSupportZoom(false);//recomendado pelo android pois n sabe como ira se comportar caso dê zoom

        //recuperando os dados passado da activity que chamou essa activity
        Intent it = getIntent();
        noticiaAtual = it.getParcelableExtra("Noticia");
        RecuperaDados rcd = new RecuperaDados(URL_ACT,"BuscarTexto",noticiaAtual.getID());
        rcd.execute();

    }

    public class RecuperaDados extends AsyncTask<Void, Void, ArrayList<Noticias_Classe>> {

        private ProgressDialog load;
        private int num;
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
            load = ProgressDialog.show(MostrarNoticiaActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
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
                noticia.setTexto("Texto não buscado no servidor");
                ArrayList<Noticias_Classe> listaNoticias = new ArrayList<Noticias_Classe>();
                listaNoticias.add(noticia);
                return listaNoticias;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Noticias_Classe> listaNoticias) {
            texto = "<html>" +
                    " <head></head>" +
                    " <body style=text-align:justify;color:black;background-color:#eeeeee;>" +
                    listaNoticias.get(0).getTexto() +
                    "</body>" +
                    "</html>";
            tituloAtual.setText(noticiaAtual.getTitulo());
            wv.loadData(texto, "text/html; charset=utf-8", "utf-8");
            load.dismiss();
        }
    }
}
