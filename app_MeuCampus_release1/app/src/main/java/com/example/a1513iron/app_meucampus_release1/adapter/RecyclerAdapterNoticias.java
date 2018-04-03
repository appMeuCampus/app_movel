package com.example.a1513iron.app_meucampus_release1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;
import com.example.a1513iron.app_meucampus_release1.viewholder.NoticiaViewHolder;
import com.example.a1513iron.app_meucampus_release1.viewholder.ViewHolder;

import java.util.List;

public class RecyclerAdapterNoticias extends RecyclerView.Adapter<NoticiaViewHolder>{

    private List<Noticias_Classe> list;
    private OnListClickInteractionListener mOnListClickInterationListener;

    public RecyclerAdapterNoticias(List<Noticias_Classe> list, OnListClickInteractionListener listener){
        this.list = list;
        mOnListClickInterationListener = listener;
    }


    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_noticia,parent,false);

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticia,parent,false);

        return new NoticiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {

        Noticias_Classe noticiaa = list.get(position);
        holder.bindData(noticiaa,mOnListClickInterationListener);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}