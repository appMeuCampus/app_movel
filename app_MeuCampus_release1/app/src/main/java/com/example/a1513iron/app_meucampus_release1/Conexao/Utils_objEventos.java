package com.example.a1513iron.app_meucampus_release1.Conexao;

import android.util.Log;

import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

/**
 * Created by BLDO on 30/04/2018.
 */

public class Utils_objEventos {

    public ArrayList<Eventos_Classe> BuscarPorIndex(String url, int parametro) throws JSONException {

        String json;
        json = NetworkUtils.getJSONFromAPI(url);
        Log.i("teste",json);
        ArrayList<Eventos_Classe> listaEventos = new ArrayList<Eventos_Classe>();
        Eventos_Classe evento = new Eventos_Classe();
        JSONArray jsonObj = new JSONArray(json);

        if(parametro < jsonObj.length() && jsonObj.getJSONObject(0).getInt("id") != -1) {// verifica se o index existe
            for(int i = 0; i < jsonObj.length(); i++) {
                evento = new Eventos_Classe();
                evento.setId((jsonObj.getJSONObject(i).getInt("id")));
                evento.setNome(jsonObj.getJSONObject(i).getString("nome"));
                evento.setData_inicial(jsonObj.getJSONObject(i).getString("data_inicial"));
                evento.setNumero_de_eventos(jsonObj.length());

                listaEventos.add(evento);
            }
            return listaEventos;
        }else{
            evento.setNome("Erro ao buscar noticia no servidor!");
            evento.setId(-1);
            listaEventos.add(evento);
            return listaEventos;
        }
    }

    public ArrayList<Eventos_Classe> BuscarPorID(String url,int id) throws JSONException {

        String json;
        json = NetworkUtils.getJSONFromAPI(url + id);
        Log.i("evento json:","oi" + json);
        ArrayList<Eventos_Classe> listaEventos = new ArrayList<Eventos_Classe>();
        Eventos_Classe eventoo = new Eventos_Classe();

        JSONArray jsonObj = new JSONArray(json);
        for(int i = 0; i < jsonObj.length(); i++){
            if(jsonObj.getJSONObject(i).getInt("id") == id){
                eventoo.setId((jsonObj.getJSONObject(i).getInt("id")));
                eventoo.setNome(jsonObj.getJSONObject(i).getString("nome"));
                eventoo.setData_inicial(jsonObj.getJSONObject(i).getString("data_inicial"));
                eventoo.setData_final(jsonObj.getJSONObject(i).getString("data_final"));
                eventoo.setDescricao(jsonObj.getJSONObject(i).getString("descricao"));
                eventoo.setHora_inicio(jsonObj.getJSONObject(i).getString("hora_inicial"));
                eventoo.setHora_termino(jsonObj.getJSONObject(i).getString("hora_final"));
                eventoo.numero_de_eventos = jsonObj.length();

            }
        }
        listaEventos.add(eventoo);
        return listaEventos;

    }

    public ArrayList<Eventos_Classe> getInformacaoEventos(String url, String operacao, int num) throws JSONException {

        //Log.i("teste",operacao);
        if(operacao == "BuscarPorIndex"){
            return BuscarPorIndex(url,num);
        }else if(operacao == "BuscarPorID"){
            return BuscarPorID(url,num);
        }else{
            Eventos_Classe evento = new Eventos_Classe();
            evento.setNome("OPERAÇÃO SOLICITADA INVÁLIDA");
            evento.setId(-2);
            ArrayList<Eventos_Classe> listaNoticias = new ArrayList<Eventos_Classe>();
            listaNoticias.add(evento);
            return listaNoticias;

        }

    }
}
