package com.example.a1513iron.app_meucampus_release1.classes;

import java.util.Date;

/**
 * Created by 1513 IRON on 19/12/2017.
 */

public class Cardapio_Classe {

    private int id;
    //private String tipo_refeicao;
    private String a1,a2,a3,a4,a5,a6;
    private String j1,j2,j3,j4,j5,j6;
    private String data;

    public Cardapio_Classe(){
        for(int i = 0; i < 6; i++){
            a1 = "-";a2 = "-";a3 = "-";a4 = "-";a5 = "-";a6 = "-";
            j1 = "-";j2 = "-";j3 = "-";j4 = "-";j5 = "-";j6 = "-";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public String getTipo_refeicao() {
        return tipo_refeicao;
    }

    public void setTipo_refeicao(String tipo_refeicao) {
        this.tipo_refeicao = tipo_refeicao;
    }*/

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public String getJ1() {
        return j1;
    }

    public void setJ1(String j1) {
        this.j1 = j1;
    }

    public String getJ2() {
        return j2;
    }

    public void setJ2(String j2) {
        this.j2 = j2;
    }

    public String getJ3() {
        return j3;
    }

    public void setJ3(String j3) {
        this.j3 = j3;
    }

    public String getJ4() {
        return j4;
    }

    public void setJ4(String j4) {
        this.j4 = j4;
    }

    public String getJ5() {
        return j5;
    }

    public void setJ5(String j5) {
        this.j5 = j5;
    }

    public String getJ6() {
        return j6;
    }

    public void setJ6(String j6) {
        this.j6 = j6;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

