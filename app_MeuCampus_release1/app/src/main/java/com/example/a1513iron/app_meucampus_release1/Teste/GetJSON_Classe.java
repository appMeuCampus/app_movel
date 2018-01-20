package com.example.a1513iron.app_meucampus_release1.Teste;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by 1513 IRON on 18/01/2018.
 */

public class GetJSON_Classe extends AsyncTask<Void, Void, Noticias_Classe>{

        public int numero_noticias = 0;
        private int index = 0;
        private int id = -1;
        private String titulo;

    public GetJSON_Classe(int index) {
        this.index = index;
    }

    public GetJSON_Classe() {

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
            numero_noticias = noticiaa.numero_de_noticias;
    }


    public Noticias_Classe BuscarNoticiaPorID(int id) throws ExecutionException, InterruptedException {

        GetJSON_Classe download = new GetJSON_Classe();
        ArrayList<Noticias_Classe> aux = download.BuscarListaNoticias(4);
        Noticias_Classe aux2 = new Noticias_Classe();

        Log.i("oi", "porra" + aux.size());


        for(int i = 0;i < aux.size();i++){
            Log.i("aux","aux[" + i + "] = " + aux.get(i).getID());
            if(aux.get(i).getID() == id){
                aux2 = aux.get(i);
            }
        }
            return aux2;

    }

    public Noticias_Classe BuscarNoticiaPorIndex(int i) throws ExecutionException, InterruptedException {

        GetJSON_Classe download = new GetJSON_Classe(i);
        download.execute();

        return download.get();
    }

    public ArrayList<Noticias_Classe> BuscarListaNoticias(int n) throws ExecutionException, InterruptedException {

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
}


