package com.example.a1513iron.app_meucampus_release1.classes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;

import org.w3c.dom.Text;


public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView textoA1;
    public TextView textoJ1;
    public TextView textoA2;
    public TextView textoJ2;
    public TextView textoA3;
    public TextView textoJ3;
    public TextView textoA4;
    public TextView textoJ4;
    public TextView textoA5;
    public TextView textoJ5;
    public TextView textoA6;
    public TextView textoJ6;
    public TextView dia_semana;

    public ViewHolder(View itemView) {
        super(itemView);

        this.textoA1 = itemView.findViewById(R.id.a1);
        this.textoJ1 = itemView.findViewById(R.id.j1);
        this.textoA2 = itemView.findViewById(R.id.a2);
        this.textoJ2 = itemView.findViewById(R.id.j2);
        this.textoA3 = itemView.findViewById(R.id.a3);
        this.textoJ3 = itemView.findViewById(R.id.j3);
        this.textoA4 = itemView.findViewById(R.id.a4);
        this.textoJ4 = itemView.findViewById(R.id.j4);
        this.textoA5 = itemView.findViewById(R.id.a5);
        this.textoJ5 = itemView.findViewById(R.id.j5);
        this.textoA6 = itemView.findViewById(R.id.a6);
        this.textoJ6 = itemView.findViewById(R.id.j6);
        this.dia_semana = itemView.findViewById(R.id.dia_da_semana);
    }
}
