package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

import java.util.Calendar;

public class CardapioActivity extends Toolbar_Classe {

    private Button botao;
    String data;
    private Context mContext;

    static final int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        botao = (Button) findViewById(R.id.btn_cardapio);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == botao)
                    showDialog(DATE_DIALOG_ID);
            }
        });
        this.mContext = this;

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Cardápio");
        CreateDrawerLayout();

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();

        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, ano, mes,
                        dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    data = ((dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth)) + "/"
                            +((monthOfYear + 1 < 10)? "0" + String.valueOf(monthOfYear + 1):String.valueOf(monthOfYear + 1)) + "/" + String.valueOf(year);
                    Toast.makeText(CardapioActivity.this,
                            "DATA =" + data, Toast.LENGTH_SHORT)
                            .show();
                    Intent intent = new Intent(mContext, MostrarCardapioActivity.class);
                    System.out.println(data);
                    intent.putExtra("Data", data);
                    startActivity(intent);
                }
            };

}
