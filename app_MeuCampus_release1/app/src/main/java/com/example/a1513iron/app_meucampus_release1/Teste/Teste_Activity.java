package com.example.a1513iron.app_meucampus_release1.Teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
        t_titulo.setText("Titulo");
        t_id.setText("ID");

       // load = ProgressDialog.show(this.getApplicationContext(), "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        GetJSON_Classe teste = new GetJSON_Classe(this.getParent());
        Noticias_Classe n1 = new Noticias_Classe();
        try {
            n1 = teste.BuscarNoticiaPorIndex(0);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t_titulo.setText(n1.getTitulo());
        t_id.setText(Integer.toString(n1.getID()));

    }
}

