package com.example.a1513iron.app_meucampus_release1.Teste;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by BLDO on 24/03/2018.
 */

public class NoticiaHttp {

    public static final String NOTICIA_URL_JSON = "http://localhost/appmeucampus/integracao/noticia/retornarNoticias";
    public  static String retorno;

    private static HttpURLConnection conectar(String urlArquivo) throws IOException{
        final int SEGUNDOS = 1000;
        URL url = new URL(urlArquivo);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setReadTimeout(10*SEGUNDOS);
        conexao.setConnectTimeout(15*SEGUNDOS);
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        conexao.setDoOutput(false);
        try {
            conexao.connect();
        }catch(java.net.SocketTimeoutException e){
            System.err.println("erro de conexão com o servidor");
            conexao.disconnect();
            retorno  = "[{\"id\":\"-1\",\"titulo\":\"Sem conexão com o servidor!\"}]";

        }
        return conexao;
    }

    public static boolean temConexao(Context ctx){
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return(info != null && info.isConnected());
    }

    public static String carregarNoticiasJson(String url){
        try{
            HttpURLConnection conexao = conectar(url);
            int resposta = conexao.getResponseCode();
            if(resposta == HttpURLConnection.HTTP_OK){
                InputStream is = conexao.getInputStream();
                retorno =  bytesParaString(is);
                return retorno;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String bytesParaString(InputStream is) throws IOException{
        byte[]buffer = new byte[1024];
        // o bufferzao vai armazenar todos os bytes lidos
        ByteArrayOutputStream bufferzao = new ByteArrayOutputStream();
        // precisamos saber quantos bytes foram lidos
        int bytesLidos;
        // vamos lendo de 1kb por vez ...
        while ((bytesLidos = is.read(buffer)) != -1){
            //copiando a quantidade de de bytes lidos do buffer para o bufferzao
            bufferzao.write(buffer,0,bytesLidos);
        }
        return new String(bufferzao.toByteArray(),"UTF-8");
    }
}
