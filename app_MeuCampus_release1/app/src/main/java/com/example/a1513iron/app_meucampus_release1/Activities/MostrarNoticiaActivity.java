package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.GetJSON_Classe;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.Teste.Utils;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.URLImageParser;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;

import static android.text.Html.fromHtml;

public class MostrarNoticiaActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String texto = "vazio";
    private TextView tituloAtual;
    private TextView textoAtual;
    private Noticias_Classe noticiaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticia);

        CreateDrawerLayout();

        tituloAtual = (TextView) findViewById(R.id.textviewTituloAtual);
        textoAtual = (TextView) findViewById(R.id.textviewTextoAtual);

        //recuperando os dados passado da activity que chamou essa activity
        Intent it = getIntent();
        noticiaAtual = it.getParcelableExtra("Noticia");
        RecuperaDados rcd = new RecuperaDados("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticia?id=","BuscarTexto",noticiaAtual.getID());
        rcd.execute();




    }

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
            case R.id.menu_cardapio: {
                Toast.makeText(this, "Menu Cardapio", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CardapioActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_busao: {
                Toast.makeText(this, "Menu Busão", Toast.LENGTH_SHORT).show();
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
    public class RecuperaDados extends AsyncTask<Void, Void, Noticias_Classe> {

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

            Log.i("TEXTO",noticiaa.getTexto());
            texto = noticiaa.getTexto();
            tituloAtual.setText(noticiaAtual.getTitulo());
            //Spanned sp = Html.fromHtml(texto);
            //textoAtual.setText(sp);
            textoAtual.setText(Html.fromHtml(texto,new URLImageParser(textoAtual, getApplicationContext()), null));


            load.dismiss();

        }

    }
}
