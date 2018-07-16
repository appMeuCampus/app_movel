package com.example.a1513iron.app_meucampus_release1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.viewholder.CalendarioViewHolder;

import java.util.List;


public class RecyclerAdapterCalendario extends RecyclerView.Adapter<CalendarioViewHolder> {

    private List<Integer> list;
    private OnListClickInteractionListener mOnListClickInterationListener;
    Context context;

    public RecyclerAdapterCalendario(List<Integer> list, OnListClickInteractionListener listener){
        this.list = list;
        mOnListClickInterationListener = listener;
    }
    @Override
    public CalendarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_calendario,parent,false);

        return new CalendarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CalendarioViewHolder holder, int position) {

        int src = list.get(position);
        holder.bindData(src,context,mOnListClickInterationListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
