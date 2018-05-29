package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objCardapio;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Cardapio_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

import org.json.JSONException;

public class MostrarCardapioActivity extends Toolbar_Classe {

    private TextView textoA1;
    private TextView textoJ1;
    private TextView textoA2;
    private TextView textoJ2;
    private TextView textoA3;
    private TextView textoJ3;
    private TextView textoA4;
    private TextView textoJ4;
    private TextView textoA5;
    private TextView textoJ5;
    private TextView textoA6;
    private TextView textoJ6;
    private TextView dia_semana;
    //private static final String URL = "http://10.0.2.2/appmeucampus/integracao/cardapio/retornarCardapiosPorData?data=";
    private static final String URL = "http://app.bambui.ifmg.edu.br/integracao/cardapio/retornarCardapiosPorData?data=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cardapio);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Cardápio");
        CreateDrawerLayout();

        //identificando os componentes a serem alterados após a recuperação dos dados
        this.textoA1 = (TextView) findViewById(R.id.a1);
        this.textoJ1 = (TextView) findViewById(R.id.j1);
        this.textoA2 = (TextView) findViewById(R.id.a2);
        this.textoJ2 = (TextView) findViewById(R.id.j2);
        this.textoA3 = (TextView) findViewById(R.id.a3);
        this.textoJ3 = (TextView) findViewById(R.id.j3);
        this.textoA4 = (TextView) findViewById(R.id.a4);
        this.textoJ4 = (TextView) findViewById(R.id.j4);
        this.textoA5 = (TextView) findViewById(R.id.a5);
        this.textoJ5 = (TextView) findViewById(R.id.j5);
        this.textoA6 = (TextView) findViewById(R.id.a6);
        this.textoJ6 = (TextView) findViewById(R.id.j6);
        this.dia_semana = (TextView) findViewById(R.id.dia_da_semana);
        //recuperando data da activity CardapioActivity
        Intent it = getIntent();
        String data = it.getStringExtra("Data");
        //recuperando dados do serviço web
        RecuperaDados teste = new RecuperaDados(this.URL,data);//"08/05/2018"
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
            load = ProgressDialog.show(MostrarCardapioActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
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
            textoA1.setText(c.getA1());
            textoA2.setText(c.getA2());
            textoA3.setText(c.getA3());
            textoA4.setText(c.getA4());
            textoA5.setText(c.getA5());
            textoA6.setText(c.getA6());

            textoJ1.setText(c.getJ1());
            textoJ2.setText(c.getJ2());
            textoJ3.setText(c.getJ3());
            textoJ4.setText(c.getJ4());
            textoJ5.setText(c.getJ5());
            textoJ6.setText(c.getJ6());

            dia_semana.setText(c.getData());
            load.dismiss();
        }
    }

}
