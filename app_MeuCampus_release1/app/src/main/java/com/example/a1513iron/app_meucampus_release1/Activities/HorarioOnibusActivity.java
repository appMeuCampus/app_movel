package com.example.a1513iron.app_meucampus_release1.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

public class HorarioOnibusActivity extends Toolbar_Classe {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_onibus);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Horário de Ônibus");
        CreateDrawerLayout();

        final Button buttonSemana = (Button) findViewById(R.id.buttonbusaosemana);
        buttonSemana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostraHorarioBusaoActivity.class);
                intent.putExtra("layout", "semana");
                startActivity(intent);
            }
        });

        final Button buttonFds = (Button) findViewById(R.id.buttonbusaofds);
        buttonFds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostraHorarioBusaoActivity.class);
                intent.putExtra("layout", "fds");
                startActivity(intent);
            }
        });
    }
}
