package com.example.a1513iron.app_meucampus_release1.Teste;

import android.util.Log;

import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {


    public Noticias_Classe BuscarPorIndex(String url,int i) throws JSONException {

        String json;
        json = NetworkUtils.getJSONFromAPI(url);
        Noticias_Classe noticiaa = new Noticias_Classe();

        JSONArray jsonObj = new JSONArray(json);
        if(i < jsonObj.length()) {// verifica se o index existe
            noticiaa.setID((jsonObj.getJSONObject(i).getInt("id")));
            noticiaa.setTitulo(jsonObj.getJSONObject(i).getString("titulo"));
            noticiaa.numero_de_noticias = jsonObj.length();

            if (jsonObj.getJSONObject(i).has("texto") == true)
                noticiaa.setTexto(jsonObj.getJSONObject(i).getString("texto"));

            return noticiaa;
        }else{
            noticiaa.setTitulo("Erro ao buscar noticia no servidor!");
            noticiaa.setID(-5);
            return noticiaa;
        }

    }

    public Noticias_Classe BuscarPorID(String url,int id) throws JSONException {

        String json;
        json = NetworkUtils.getJSONFromAPI(url);
        Noticias_Classe noticiaa = new Noticias_Classe();

        JSONArray jsonObj = new JSONArray(json);
        for(int i = 0; i < jsonObj.length(); i++){
            if(jsonObj.getJSONObject(i).getInt("id") == id){
                noticiaa.setID((jsonObj.getJSONObject(i).getInt("id")));
                noticiaa.setTitulo(jsonObj.getJSONObject(i).getString("titulo"));
                noticiaa.numero_de_noticias = jsonObj.length();

                if(jsonObj.getJSONObject(i).has("texto") == true)
                    noticiaa.setTexto(jsonObj.getJSONObject(i).getString("texto"));
            }
        }

        return noticiaa;

    }

    public Noticias_Classe BuscarTexto(String url, int id) throws JSONException {

        Log.i("PASSEI AQUI","PASSEI AQUI");
        String json;
        json = NetworkUtils.getJSONFromAPI(url + id);
        Noticias_Classe noticiaa = new Noticias_Classe();
        JSONArray jsonObj = new JSONArray(json);

        if(jsonObj.getJSONObject(0).has("texto") == true) {
            noticiaa.setTexto(jsonObj.getJSONObject(0).getString("texto"));
        }else{
            noticiaa.setTexto("Texto não encontrado.");
        }
        return noticiaa;


    }

    public Noticias_Classe getInformacaoNoticias(String url, String operacao,int num) throws JSONException {

        //Log.i("teste",operacao);
        if(operacao == "BuscarPorIndex"){
            return BuscarPorIndex(url,num);
        }else if(operacao == "BuscarPorID"){
            return BuscarPorID(url,num);
        }else if(operacao == "BuscarTexto") {
            return BuscarTexto(url,num);
        }else{
                Noticias_Classe noticia = new Noticias_Classe();
                noticia.setTitulo("OPERAÇÃO SOLICITADA INVÁLIDA");
                noticia.setID(-2);
                return noticia;

        }

    }

    /*private Noticias_Classe parseJsonNoticias(String json){
        try {
            Noticias_Classe noticiaa = new Noticias_Classe();

            JSONArray jsonObj = new JSONArray(json);

            //Atribui os objetos que estão nas camadas mais altas
            noticiaa.setID((jsonObj.getJSONObject(index).getInt("id")));
            noticiaa.setTitulo(jsonObj.getJSONObject(index).getString("titulo"));
            noticiaa.numero_de_noticias = jsonObj.length();

            if(jsonObj.getJSONObject(index).has("texto") == true)
                noticiaa.setTexto(jsonObj.getJSONObject(index).getString("texto"));


            return noticiaa;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }*/


}
