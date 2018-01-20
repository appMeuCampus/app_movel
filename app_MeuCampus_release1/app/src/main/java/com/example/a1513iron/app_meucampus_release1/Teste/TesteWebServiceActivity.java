package com.example.a1513iron.app_meucampus_release1.Teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.concurrent.ExecutionException;

public class TesteWebServiceActivity extends AppCompatActivity {

    private  TextView t_id;
    private  TextView t_titulo;
    public Noticias_Classe noticia = new Noticias_Classe();

    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        Integracao download = new Integracao(2);

        t_id = (TextView) findViewById(R.id.t_textView);
        t_titulo = (TextView) findViewById(R.id.t_textView2);


        //Chama Async Task
        download.execute();
        try {
            t_id.setText(Integer.toString(download.get().getID()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            t_titulo.setText(download.get().getTitulo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class GetJson extends AsyncTask<Void, Void, Noticias_Classe> {

        private int index;
        public GetJson(int i) {
            this.index = i;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(TesteWebServiceActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Noticias_Classe doInBackground(Void... params) {
            Utils util = new Utils();

            return util.getInformacao("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias",this.index);
        }

        @Override
        protected void onPostExecute(Noticias_Classe noticiaa) {

            load.dismiss();
        }
    }

}

