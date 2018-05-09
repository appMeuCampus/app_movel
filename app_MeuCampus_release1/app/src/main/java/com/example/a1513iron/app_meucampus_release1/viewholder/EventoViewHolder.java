package com.example.a1513iron.app_meucampus_release1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;

/**
 * Created by BLDO on 08/05/2018.
 */

public class EventoViewHolder extends RecyclerView.ViewHolder {

    public TextView titulo;

    public EventoViewHolder(View itemView) {
        super(itemView);
        this.titulo = (TextView) itemView.findViewById(R.id.card_nome_evento);
    }

    public void bindData(final Eventos_Classe eventoo, final OnListClickInteractionListener listener){
        this.titulo.setText(eventoo.getNome());
        this.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(eventoo);
            }
        });
    }
}
