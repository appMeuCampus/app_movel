package com.example.a1513iron.app_meucampus_release1.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.Conexao.Utils_objNoticia;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

import org.json.JSONException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Toolbar_Classe{

    private ImageView imgfeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Principal");
        CreateDrawerLayout();
        imgfeed = findViewById(R.id.imgfeed);
        WebView wv = (WebView) findViewById(R.id.webviewfeed);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setSupportZoom(false);//recomendado pelo android pois n sabe como ira se comportar caso dê zoom
        wv.loadData(getString(R.string.main), "text/html; charset=utf-8", "utf-8");

    }
}
