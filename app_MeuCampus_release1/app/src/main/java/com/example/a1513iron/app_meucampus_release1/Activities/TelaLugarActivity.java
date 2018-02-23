package com.example.a1513iron.app_meucampus_release1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;

public class TelaLugarActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lugar);

        String nome_do_lugar = getIntent().getStringExtra("nomeLugar");
        textView = (TextView) findViewById(R.id.textView2);
        textView.setText(nome_do_lugar);
    }
}
