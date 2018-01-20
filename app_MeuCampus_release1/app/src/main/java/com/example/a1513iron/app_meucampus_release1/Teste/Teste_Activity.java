package com.example.a1513iron.app_meucampus_release1.Teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Teste_Activity extends AppCompatActivity {

    private  TextView t_id;
    private  TextView t_titulo;
    public Noticias_Classe noticia = new Noticias_Classe();

    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        t_titulo = (TextView) findViewById(R.id.t_textView);
        t_id = (TextView) findViewById(R.id.t_textView2);

        GetJSON_Classe teste = new GetJSON_Classe();

        try {
            noticia = teste.BuscarNoticiaPorID(8);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        t_id.setText(Integer.toString(noticia.getID()));
        t_titulo.setText(noticia.getTitulo());

    }

}

