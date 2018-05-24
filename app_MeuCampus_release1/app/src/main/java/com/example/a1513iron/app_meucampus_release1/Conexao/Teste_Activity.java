package com.example.a1513iron.app_meucampus_release1.Conexao;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Cardapio_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;

import org.json.JSONException;

import java.util.ArrayList;

public class Teste_Activity extends AppCompatActivity {

    private TextView t_id;
    private TextView t_titulo;
    public static final String URL = "http://10.0.2.2/appmeucampus/integracao/cardapio/retornarCardapiosPorData?data=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        t_titulo = (TextView) findViewById(R.id.t_textView);
        t_id = (TextView) findViewById(R.id.t_textView2);
        t_titulo.setText("Nome");
        t_id.setText("ID");

        RecuperaDados teste = new RecuperaDados(this.URL, "15/11/2017");
        teste.execute();

    }

    public class RecuperaDados extends AsyncTask<Void, Void, Cardapio_Classe> {

        private ProgressDialog load;
        private String data;
        String endereco;

        public RecuperaDados(String url, String data) {
            this.endereco = url;
            this.data = data;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(Teste_Activity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Cardapio_Classe doInBackground(Void... params) {
            Utils_objCardapio util = new Utils_objCardapio();
            try {
                return util.getInformacaoCardapio(endereco+data);
            } catch (JSONException e) {
                e.printStackTrace();
                Cardapio_Classe c = new Cardapio_Classe();
                return c;
            }
        }

        @Override
        protected void onPostExecute(Cardapio_Classe c) {
            t_titulo.setText(c.getA1() + " " + c.getA2() + " " + c.getA3() + " " + c.getA4() + " " + c.getA5() + " " + c.getA6());
            t_id.setText(c.getJ1() + " " + c.getJ2() + " " + c.getJ3() + " " + c.getJ4() + " " + c.getJ5() + " " + c.getJ6());
            load.dismiss();
        }
    }
}
