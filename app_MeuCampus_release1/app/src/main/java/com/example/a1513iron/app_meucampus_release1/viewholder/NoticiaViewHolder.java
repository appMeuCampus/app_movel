package com.example.a1513iron.app_meucampus_release1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;


/**
 * Created by BLDO on 03/04/2018.
 */

public class NoticiaViewHolder extends RecyclerView.ViewHolder {

    public TextView titulo;

    public NoticiaViewHolder(View itemView) {
        super(itemView);
        this.titulo = (TextView) itemView.findViewById(R.id.card_titulo_noticia);
    }

    public void bindData(final Noticias_Classe noticiaa, final OnListClickInteractionListener listener){
        this.titulo.setText(noticiaa.getTitulo());
        this.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(noticiaa);
            }
        });
    }
}
