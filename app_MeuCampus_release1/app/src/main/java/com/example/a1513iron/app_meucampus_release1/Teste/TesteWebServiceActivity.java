package com.example.a1513iron.app_meucampus_release1.Teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

public class TesteWebServiceActivity extends AppCompatActivity {

    private  TextView t_id;
    private  TextView t_titulo;

    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        GetJson download = new GetJson();

        t_id = (TextView) findViewById(R.id.t_textView);
        t_titulo = (TextView) findViewById(R.id.t_textView2);


        //Chama Async Task
        download.execute();
    }

    private class GetJson extends AsyncTask<Void, Void, Noticias_Classe> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(TesteWebServiceActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Noticias_Classe doInBackground(Void... params) {
            Utils util = new Utils();

            return util.getInformacao("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias");
        }

        @Override
        protected void onPostExecute(Noticias_Classe noticiaa) {

            t_id.setText(Integer.toString(noticiaa.getID()));
            t_titulo.setText(noticiaa.getTitulo());

            load.dismiss();
        }
    }
}

