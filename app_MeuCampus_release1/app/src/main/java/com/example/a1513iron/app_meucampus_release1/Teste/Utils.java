package com.example.a1513iron.app_meucampus_release1.Teste;

import android.util.Log;

import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    private int index;

    public Noticias_Classe getInformacaoNoticias(String end, int i){
        String json;
        this.index = i;
        Noticias_Classe retorno;
        json = NetworkUtils.getJSONFromAPI(end);
        retorno = parseJsonNoticias(json);

        return retorno;
    }

    private Noticias_Classe parseJsonNoticias(String json){
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
    }


}
