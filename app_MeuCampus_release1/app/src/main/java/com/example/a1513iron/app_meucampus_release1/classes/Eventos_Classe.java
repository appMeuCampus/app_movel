package com.example.a1513iron.app_meucampus_release1.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BLDO on 30/04/2018.
 */

public class Eventos_Classe implements Parcelable {


    public int numero_de_eventos = 0;
    private int id = 0;
    private String descricao;
    private String nome = "esse objto está com valor default";
    private Calendar data_inicial = Calendar.getInstance();


    public Eventos_Classe(){}

    public Eventos_Classe(Parcel in) {
        numero_de_eventos = in.readInt();
        id = in.readInt();
        nome = in.readString();
        data_inicial.setTimeInMillis(in.readLong());
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
        parcel.writeInt(numero_de_eventos);
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeLong(data_inicial.getTimeInMillis());
    }

    public int getNumero_de_eventos() {
        return numero_de_eventos;
    }

    public void setNumero_de_eventos(int numero_de_eventos) {
        this.numero_de_eventos = numero_de_eventos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getData_inicial() {
        //formatando para pdrão br
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        return sdf.format(this.data_inicial.getTime());
    }

    public void setData_inicial(String data_inicial) {
        //splitando os valores da string retornada
        String aux[] = data_inicial.split("/");
        //iniciando
        this.data_inicial = Calendar.getInstance();
        //setando os valores de data
        this.data_inicial.set(Calendar.DAY_OF_MONTH,Integer.parseInt(aux[0]));
        this.data_inicial.set(Calendar.MONTH,Integer.parseInt(aux[1]) - 1);
        this.data_inicial.set(Calendar.YEAR,Integer.parseInt(aux[2]));

    }

}
