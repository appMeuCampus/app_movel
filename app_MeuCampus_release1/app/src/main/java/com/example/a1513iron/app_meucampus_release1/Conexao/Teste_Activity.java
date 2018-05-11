package com.example.a1513iron.app_meucampus_release1.Conexao;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;

import org.json.JSONException;

import java.util.ArrayList;

public class Teste_Activity extends AppCompatActivity {

    private TextView t_id;
    private TextView t_titulo;
    public static final String URL = "http://10.0.2.2/appmeucampus/integracao/evento/retornarEventos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        t_titulo = (TextView) findViewById(R.id.t_textView);
        t_id = (TextView) findViewById(R.id.t_textView2);
        t_titulo.setText("Nome");
        t_id.setText("ID");

        RecuperaDados teste = new RecuperaDados(this.URL, "BuscarPorIndex", 1);
        teste.execute();

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
            load = ProgressDialog.show(Teste_Activity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
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
        protected void onPostExecute(ArrayList<Eventos_Classe> eventos) {
            //System.out.println(eventos.get(0).getData_inicial());
            t_titulo.setText(eventos.get(0).getData_inicial());
            t_id.setText(Integer.toString(eventos.get(0).getId()));
            load.dismiss();
        }
    }
}
