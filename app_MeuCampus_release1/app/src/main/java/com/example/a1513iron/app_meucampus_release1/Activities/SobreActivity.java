package com.example.a1513iron.app_meucampus_release1.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

public class SobreActivity extends Toolbar_Classe{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Sobre");
        CreateDrawerLayout();

        WebView wv = (WebView) findViewById(R.id.webviewfeed);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setSupportZoom(false);//recomendado pelo android pois n sabe como ira se comportar caso dê zoom
        wv.loadData(getString(R.string.sobre), "text/html; charset=utf-8", "utf-8");

    }
}
