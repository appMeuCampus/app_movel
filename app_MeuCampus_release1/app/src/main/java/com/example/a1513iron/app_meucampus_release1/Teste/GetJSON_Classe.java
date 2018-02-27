package com.example.a1513iron.app_meucampus_release1.Teste;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.Object;

import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by 1513 IRON on 18/01/2018.
 */

public class GetJSON_Classe extends AsyncTask<Void, Void, Noticias_Classe>{

        private ProgressDialog load;
        private  Context contextoAtual;
        public int num_noticias;
        private int index;
        private int id;
        private String titulo;
        private String texto;
        String endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias"; //por default o endereco vai ser esse pois estava craashando o app se deixasse vazio... mas isso não irá interferir nas demais funções da classe pois é umavariavel q muda toda x q um método de busca é chamado

    public GetJSON_Classe(int index) {
        this.index = index;
    }
    public GetJSON_Classe(Context context) {
        this.contextoAtual = context;
    }

    public GetJSON_Classe() {
        this.index = 0;

    }

    @Override
    protected void onPreExecute() {
        //load = ProgressDialog.show(this.contextoAtual, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
    }

    @Override
        protected Noticias_Classe doInBackground(Void... params) {
            Utils util = new Utils();
            //return util.getInformacaoNoticias(endereco, index);
        return new Noticias_Classe();

        }

        @Override
        protected void onPostExecute(Noticias_Classe noticiaa) {

            id = noticiaa.getID();
            titulo = noticiaa.getTitulo();
            num_noticias = noticiaa.numero_de_noticias;

        //load.dismiss();

    }

    public int GetNumeroNoticias() throws ExecutionException, InterruptedException {
        this.endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";
        this.execute();
        return this.get().numero_de_noticias;
    }

    public boolean ExisteIndex(int i) throws ExecutionException, InterruptedException {
        this.endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";

        Log.i("teste", i + "< " + this.get().numero_de_noticias);
        if(i < this.get().numero_de_noticias) {
            return true;
        }else{
            return false;
        }

    }
    public String BuscarTextodeNoticia(int id) throws ExecutionException, InterruptedException {

        this.endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticia?id=" + id;
        this.execute();
        this.setTexto(this.get().getTexto());

        return this.getTexto();
    }


    public Noticias_Classe BuscarNoticiaPorID(int id) throws ExecutionException, InterruptedException {

        this.endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";
        this.execute();

        ArrayList<Noticias_Classe> aux = this.BuscarListaNoticias(this.get().numero_de_noticias);
        Noticias_Classe aux2 = new Noticias_Classe();

        for(int i = 0;i < aux.size();i++){
            if(aux.get(i).getID() == id){
                aux2 = aux.get(i);
            }
        }
            return aux2;
    }

    public Noticias_Classe BuscarNoticiaPorIndex(int i) throws ExecutionException, InterruptedException {

        this.endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";
        this.index = i;
        this.execute();

        return this.get();
    }

    public ArrayList<Noticias_Classe> BuscarListaNoticias(int n) throws ExecutionException, InterruptedException {

        this.endereco = "http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias";
        ArrayList<Noticias_Classe> lista_noticias = new ArrayList<>();

        for(int i = 0; i < n;i++){
            GetJSON_Classe download = new GetJSON_Classe(i);
            download.execute();
            lista_noticias.add(download.get());
        }

        return lista_noticias;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}


