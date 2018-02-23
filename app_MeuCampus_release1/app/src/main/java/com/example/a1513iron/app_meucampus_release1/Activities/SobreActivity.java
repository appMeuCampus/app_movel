package com.example.a1513iron.app_meucampus_release1.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.Teste_Activity;

public class SobreActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {

            case R.id.menu_meucampus: {
                Toast.makeText(this, "Menu MeuCampus", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.menu_noticias: {
                Toast.makeText(this, "Menu Noticias", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListaNoticiasActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_cardapio: {
                Toast.makeText(this, "Menu Cardapio", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CardapioActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_busao: {
                Toast.makeText(this, "Menu Busão", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_mapa: {
                Toast.makeText(this, "Menu Mapa", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_teste: {
                Toast.makeText(this, "Menu Teste", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Teste_Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_sobre: {
                Toast.makeText(this, "Menu Teste", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(intent);
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }




}
