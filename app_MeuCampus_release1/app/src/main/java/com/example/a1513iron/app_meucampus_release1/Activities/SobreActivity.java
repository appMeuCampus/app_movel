package com.example.a1513iron.app_meucampus_release1.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Toolbar_Classe;

public class SobreActivity extends Toolbar_Classe{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Sobre");
        CreateDrawerLayout();

        TextView texto = (TextView) findViewById(R.id.sobre_texto);
        texto.setText("Olá! Seja bem-vindo ao aplicativo do IFMG - Campus Bambuí!\n" +
                "\n" +
                "\n" +
                "\n" +
                "A proposta é que ele seja um novo meio de comunicação entre a Instituição e seus alunos, professores e funcionários. \n" +
                "\n" +
                "\n" +
                "\n" +
                "Você está utilizando a versão inicial do aplicativo, por isso apenas algumas funcionalidades estão disponíveis neste momento. Esperamos melhorá-lo continuamente, de maneira que ele se transforme em um novo meio de comunicação entre a Instituição e seus alunos, professores e funcionários, bem como ofereça acesso a serviços acadêmicos específicos.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Qualquer dúvida, crítica, sugestão ou elogio que você quiser compartilhar com a equipe do projeto, basta enviar um e-mail para appmeucampus@ifmg.edu.br.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Muito obrigado! ");
    }
}
