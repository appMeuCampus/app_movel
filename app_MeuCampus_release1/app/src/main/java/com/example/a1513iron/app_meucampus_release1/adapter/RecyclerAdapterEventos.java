package com.example.a1513iron.app_meucampus_release1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.viewholder.EventoViewHolder;
import com.example.a1513iron.app_meucampus_release1.viewholder.NoticiaViewHolder;

import java.util.List;

/**
 * Created by BLDO on 08/05/2018.
 */

public class RecyclerAdapterEventos extends RecyclerView.Adapter<EventoViewHolder> {

    private List<Eventos_Classe> list;
    private OnListClickInteractionListener mOnListClickInterationListener;

    public RecyclerAdapterEventos(List<Eventos_Classe> list, OnListClickInteractionListener listener){
        this.list = list;
        mOnListClickInterationListener = listener;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_evento,parent,false);

        return new EventoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventoViewHolder holder, int position) {
        Eventos_Classe eventoo = list.get(position);
        holder.bindData(eventoo,mOnListClickInterationListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
