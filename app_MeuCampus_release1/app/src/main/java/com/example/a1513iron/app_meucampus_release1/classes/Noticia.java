package com.example.a1513iron.app_meucampus_release1.classes;

import java.io.Serializable;

public class Noticia implements Serializable {

    public String titulo;
    public int id;

    public Noticia(){

    }

    public Noticia(String Titulo,int id){
        this.id = id;
        this.titulo = titulo;
    }

    public String ToString(){
        return titulo;
    }
}