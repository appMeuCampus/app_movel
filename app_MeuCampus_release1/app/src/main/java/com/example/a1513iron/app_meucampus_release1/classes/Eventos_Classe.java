package com.example.a1513iron.app_meucampus_release1.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by BLDO on 30/04/2018.
 */

public class Eventos_Classe implements Parcelable {


    public int numero_de_eventos = 0;
    private int id = 0;
    private String nome = "esse objto está com valor default";
    private Date data_inicial;
    private Date data_final;


    public Eventos_Classe(){}

    public Eventos_Classe(Parcel in) {
        this.id = in.readInt();
        this.nome = in.readString();
    }

    public static final Creator<Eventos_Classe> CREATOR = new Creator<Eventos_Classe>() {
        @Override
        public Eventos_Classe createFromParcel(Parcel in) {
            return new Eventos_Classe(in);
        }

        @Override
        public Eventos_Classe[] newArray(int size) {
            return new Eventos_Classe[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public int getNumero_de_eventos() {
        return numero_de_eventos;
    }

    public void setNumero_de_eventos(int numero_de_eventos) {
        this.numero_de_eventos = numero_de_eventos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }
}
