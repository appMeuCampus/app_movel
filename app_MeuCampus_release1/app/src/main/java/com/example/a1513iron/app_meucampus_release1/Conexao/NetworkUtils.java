package com.example.a1513iron.app_meucampus_release1.Conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {

    public static final int SEGUNDOS = 1000;

    //Responsavel por carregar o Objeto JSON
    public static String getJSONFromAPI(String url) {
        String retorno = "";
        try {
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection conexao = (HttpURLConnection) apiEnd.openConnection();;
            InputStream is;

            conexao.setRequestMethod("GET");
            conexao.setReadTimeout(5*SEGUNDOS);
            conexao.setConnectTimeout(5*SEGUNDOS);
            try {
                conexao.connect();
            }catch(java.net.SocketTimeoutException e){
                System.err.println("erro de conexão com o servidor");
                conexao.disconnect();
                retorno  = "[{\"id\":\"-1\",\"titulo\":\"Sem conexão com o servidor!\"}]";
                return retorno;

            }

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                is = conexao.getInputStream();
            } else {
                is = conexao.getErrorStream();
            }

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    private static String converterInputStreamToString(InputStream is) {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
