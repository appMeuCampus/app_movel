package com.example.a1513iron.app_meucampus_release1.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.Conexao.Teste_Activity;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.adapter.RecyclerAdapterCalendario;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

import java.util.ArrayList;
import java.util.List;
//import com.master.glideimageview.GlideImageView;

public class CalendarioAcademicoActivity extends Toolbar_Classe {

    private FragmentActivity fa;
    // Hold a reference to the current animator,
    // so that it can be canceled mid-way.
    private Animator mCurrentAnimator;

    // The system "short" animation time duration, in milliseconds. This
    // duration is ideal for subtle animations or animations that occur
    // very frequently.
    private int mShortAnimationDuration;
    private List<Integer> list = new ArrayList<>();
    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    private static class ViewHolder{
        RecyclerView recyclerCalendario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_academico);

        this.mContext = this;

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Calendário Acadêmico");
        CreateDrawerLayout();

        //obter o recyler
        this.mViewHolder.recyclerCalendario = (RecyclerView) this.findViewById(R.id.recycler_view_calendario);

        //definir o layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.mViewHolder.recyclerCalendario.setLayoutManager(linearLayoutManager);

        //list.add(R.drawable.ca1);list.add(R.drawable.ca2);list.add(R.drawable.ca3);list.add(R.drawable.ca4);
        list.add(R.drawable.ca5);list.add(R.drawable.ca6);list.add(R.drawable.ca7);list.add(R.drawable.ca8);list.add(R.drawable.ca9);
        RecyclerAdapterCalendario ca_adapter = new RecyclerAdapterCalendario(list,listener);
        mViewHolder.recyclerCalendario.setAdapter(ca_adapter);

    }

    // Implementa o evento de click para passar por parâmetro para a ViewHolder
    OnListClickInteractionListener listener = new OnListClickInteractionListener() {
        @Override
        public void onClick(Noticias_Classe noticiaa) {
        }
        @Override
        public void onClick(Integer src,View view) {
            //zoomImageFromThumb(view, src);
        }
        @Override
        public void onClick(Eventos_Classe eventoo) {

        }
    };



}
