package com.example.a1513iron.app_meucampus_release1.Teste;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import org.json.JSONException;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Teste_Activity extends AppCompatActivity {

    private  TextView t_id;
    private  TextView t_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        t_titulo = (TextView) findViewById(R.id.t_textView);
        t_id = (TextView) findViewById(R.id.t_textView2);
        t_titulo.setText("Titulo");
        t_id.setText("ID");

       // RecuperaDados teste = new RecuperaDados("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias","BuscarPorIndex",1);
       // teste.execute();

    }/*
    public class RecuperaDados extends AsyncTask<Void, Void, Noticias_Classe> {

        private ProgressDialog load;
        private int num;
        String operacao;
        String endereco;

        public RecuperaDados(String url, String operacao,int num){
            this.endereco = url;
            this.operacao = operacao;
            this.num = num;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(Teste_Activity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
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

            t_titulo.setText(noticiaa.getTitulo());
            t_id.setText(Integer.toString(noticiaa.getID()));

            load.dismiss();

        }

    }*/

}
