package com.example.a1513iron.app_meucampus_release1.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Noticias_Classe implements Parcelable{

    public int numero_de_noticias = 0;
    private int ID = 0;
    private String titulo = "Noticia";
    private String texto = "Bla bla bla bla bla...";
    private Date data_publicacao;
    private Date data_atualizacao;

    public Noticias_Classe(){

    }

    protected Noticias_Classe(Parcel in) {
        numero_de_noticias = in.readInt();
        ID = in.readInt();
        titulo = in.readString();
        texto = in.readString();
    }

    public static final Creator<Noticias_Classe> CREATOR = new Creator<Noticias_Classe>() {
        @Override
        public Noticias_Classe createFromParcel(Parcel in) {
            return new Noticias_Classe(in);
        }

        @Override
        public Noticias_Classe[] newArray(int size) {
            return new Noticias_Classe[size];
        }
    };

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTexto(){
        return this.texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    @Override
    public String toString(){
        return this.getTitulo();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(numero_de_noticias);
        parcel.writeInt(ID);
        parcel.writeString(titulo);
        parcel.writeString(texto);
    }
}
