package com.example.a1513iron.app_meucampus_release1.Activities.listener;

import android.view.View;

import com.example.a1513iron.app_meucampus_release1.classes.Eventos_Classe;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

/**
 * Interface utilizada para lidar com eventos na listagem
 */
public interface OnListClickInteractionListener {

    /**
     * Trata evento de click na lista
     * @param noticiaa
     */
    void onClick(Noticias_Classe noticiaa);
    void onClick(Eventos_Classe noticiaa);
    void onClick(Integer src, View view);

}