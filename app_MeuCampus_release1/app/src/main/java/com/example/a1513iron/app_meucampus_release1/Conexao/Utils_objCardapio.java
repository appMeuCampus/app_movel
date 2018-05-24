package com.example.a1513iron.app_meucampus_release1.Conexao;

import android.util.Log;

import com.example.a1513iron.app_meucampus_release1.classes.Cardapio_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by BLDO on 14/05/2018.
 */

public class Utils_objCardapio {
    public Cardapio_Classe BuscarPorData(String url) throws JSONException {

        String json;
        json = NetworkUtils.getJSONFromAPI(url);
        Log.i("teste", json);
        Cardapio_Classe cardapioo = new Cardapio_Classe();
        JSONArray jsonObj = new JSONArray(json);

        //o id da janta é diferente do id do almoço, mas como a abstração proposta para o cardápio é exibir as informações por data, faz se a soma dos id da janta e do almoço
        cardapioo.setId(jsonObj.getJSONObject(0).getInt("id") + jsonObj.getJSONObject(1).getInt("id"));
        //cardapioo.setTipo_refeicao(jsonObj.getJSONObject(0).getString("tipo_refeicao")); o tipo da refeição será pego por index
        cardapioo.setData(jsonObj.getJSONObject(0).getString("data")); //       o index 0 é almoço e o index 1 é janta
        //pegando o almoço
        String auxa[] = jsonObj.getJSONObject(0).getString("descricao").split(",");
        try {cardapioo.setA1(auxa[0]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA1("-");}
        try {cardapioo.setA2(auxa[1]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA2("-");}
        try {cardapioo.setA3(auxa[2]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA3("-");}
        try {cardapioo.setA4(auxa[3]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA4("-");}
        try {cardapioo.setA5(auxa[4]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA5("-");}
        try {cardapioo.setA6(auxa[5]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA6("-");}
        //pegando a janta
        String auxj[] = jsonObj.getJSONObject(1).getString("descricao").split(",");
        try {cardapioo.setJ1(auxj[0]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA1("-");}
        try {cardapioo.setJ2(auxj[1]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA2("-");}
        try {cardapioo.setJ3(auxj[2]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA3("-");}
        try {cardapioo.setJ4(auxj[3]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA4("-");}
        try {cardapioo.setJ5(auxj[4]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA5("-");}
        try {cardapioo.setJ6(auxj[5]);}catch(ArrayIndexOutOfBoundsException e){cardapioo.setA6("-");}
        return cardapioo;
    }

    public Cardapio_Classe getInformacaoCardapio(String url) throws JSONException {
        return BuscarPorData(url);
    }
}
