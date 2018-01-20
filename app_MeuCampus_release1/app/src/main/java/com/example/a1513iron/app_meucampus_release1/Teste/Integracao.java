package com.example.a1513iron.app_meucampus_release1.Teste;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

/**
 * Created by 1513 IRON on 18/01/2018.
 */

public class Integracao extends AsyncTask<Void, Void, Noticias_Classe>{

        private int index;
        private int id;
        private String titulo;

    public Integracao(int index) {
        this.index = index;
    }

    @Override
        protected Noticias_Classe doInBackground(Void... params) {
            Utils util = new Utils();
            return util.getInformacao("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias", index);
        }

        @Override
        protected void onPostExecute(Noticias_Classe noticiaa) {

            id = noticiaa.getID();
            titulo = noticiaa.getTitulo();
    }

    public void Executar(){

        Utils util = new Utils();

        Noticias_Classe aux = new Noticias_Classe();
        aux = util.getInformacao("http://10.0.2.2/appmeucampus/integracao/noticia/retornarNoticias", index);
        Log.i("PASSEI AQUI", "passei aqui");

        Log.i("BLDO4","peidei " + aux.getID());
        Log.i("BLDO5", "peidei " + aux.getTitulo());
        this.setId(aux.getID());
        this.setTitulo(aux.getTitulo());
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
}


