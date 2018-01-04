package com.example.a1513iron.app_meucampus_release1.Acitivities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.Teste.TesteWebServiceActivity;
import com.example.a1513iron.app_meucampus_release1.classes.Noticias_Classe;

public class MostrarNoticiaActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticia);

        CreateDrawerLayout();

        TextView tituloAtual = (TextView) findViewById(R.id.textviewTituloAtual);
        TextView textoAtual = (TextView) findViewById(R.id.textviewTextoAtual);

        //recuperando os dados passado da activity que chamou essa activity
        Intent it = getIntent();
        Noticias_Classe noticiaAtual = it.getParcelableExtra("Noticia");

        if(noticiaAtual != null){
            if(noticiaAtual.getID() == 1){
                tituloAtual.setText(noticiaAtual.getTitulo());
                //textoAtual.setText(n1.getTexto());
                textoAtual.setText("Foi iniciado o processo de Renovação de Matrícula para o semestre 2018.1 no Portal Educacional - CONECTA (MeuIFMG).\n" +
                        "\n" +
                        "O processo acontece de modo diferente para os alunos dos Cursos Técnicos e de Graduação: \n" +
                        "\n" +
                        "- Alunos de Cursos Técnicos Integrados - É obrigatório realizar o processo de Renovação de Matrícula via MeuIFMG. É através deste processo que o aluno garantirá sua matrícula no ano seguinte. As informações de como executar este processo estão ao fim deste texto.\n" +
                        "\n" +
                        "- Alunos de Cursos Técnicos Subsequentes e alunos dos Cursos de Graduação - São necessários duas etapas:\n" +
                        "\n" +
                        "1.      É obrigatório realizar o processo de Renovação de Matrícula via MeuIFMG para que seja renovado o vínculo do estudante com a instituição.\n" +
                        "\n" +
                        "2.      Realizar o processo de Sugestão de Matrícula onde o estudante indicará quais disciplinas ele irá cursar no próximo semestre.\n" +
                        "\n" +
                        "Abaixo são apresentadas mais informações sobre os processos de Solicitação da Renovação de Matrícula e sobre o período de Sugestão de Matrícula:\n" +
                        "\n" +
                        "* SOLICITAÇÃO DA RENOVAÇÃO DE MATRÍCULA: \n" +
                        "\n" +
                        "Período para solicitar a renovação de matrícula começa em de 15 de dezembro de 2017.\n" +
                        "\n" +
                        "COMO FAZER?\n" +
                        "\n" +
                        "O preenchimento do questionário socioeconômico e a execução da solicitação da renovação de matrícula é feita via portal. Se houver dúvidas, basta seguir o tutorial do link: https://www.youtube.com/watch?v=XvnL8RV17TE\n" +
                        "\n" +
                        "* SUGESTÃO DE MATRÍCULA: \n" +
                        "\n" +
                        "- Quem deve participar?  Alunos de Cursos Técnicos Subsequentes e alunos dos Cursos de Graduação\n" +
                        "\n" +
                        "            - Cursos Superiores: 18 a 28 de janeiro via MeuIFMG\n" +
                        "\n" +
                        "            - Cursos Técnicos subsequentes: 15 a 28 de fevereiro via Coordenação de Curso.\n" +
                        "\n" +
                        "O resultado da Sugestão de Matrícula para os Cursos de Graduação estará disponível a partir do dia 31 de janeiro.\n" +
                        "\n" +
                        "IMPORTANTE: Para ter acesso ao processo de Sugestão de Matrícula o estudante terá que ter feito a renovação de matrícula com pelo menos 24 horas de antecedência. \n" +
                        "\n" +
                        "COMO FAZER:\n" +
                        "\n" +
                        "Alunos dos cursos de graduação selecionam as disciplinas em  que vão concorrer a uma vaga para o próximo período letivo, sendo o Ajuste de Matrícula a segunda reabertura do processo de escolha com as disciplinas que ainda possuírem vagas após a Sugestão de Matrícula. Segue o link do tutorial: https://www.youtube.com/watch?v=9cvhYgZgkI0\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "TODAS AS DÚVIDAS E PROBLEMAS DEVEM SER ENCAMINHADOS PARA O E-MAIL: meuifmg.bambui@ifmg.edu.br  \n" +
                        "\n" +
                        "Fonte: Equipe de Implantação do Projeto Conecta no IFMG - Campus Bambuí");
            }else if(noticiaAtual.getID() == 2){
                tituloAtual.setText(noticiaAtual.getTitulo());
                //textoAtual.setText(n1.getTexto());
                textoAtual.setText("Alunos e professores dos cursos de Licenciatura em Física e em Ciências Biológicas do IFMG - Campus Bambuí participaram do VI Encontro do PIBID IFMG, realizado no Campus Congonhas, nos dias 23 e 24 de novembro de 2017, e que tem como objetivo promover a interação entre estudantes e docentes dos cursos de Licenciatura para que possam discutir e trocar experiências acerca dos desafios e prazeres em educar. Além da apresentação dos trabalhos acadêmicos, a programação do evento contou com palestras e oficinas.\n" +
                        "\n" +
                        "Os alunos dos cursos de licenciatura apresentaram 11 trabalhos desenvolvidos nas escolas estaduais de Bambuí. Dentre um total de 62 trabalhos apresentados no encontro, o trabaho intitulado \"Utilização de truques de mágicas como ferramentas lúdico pedagógicas aplicadas ao ensino de física\", apresentado pelos licenciandos em Física, Phelipe Júnior de Góis e Rafael Nunes de Oliveira, orientados pelo Prof. Dr. Mayler Martins, foi classificado em segundo lugar.\n" +
                        "\n" +
                        "O PIBID (Programa Institucional de Bolsa de Iniciação à Docência) é um programa do Ministério da Educação (MEC) que tem como objetivo incentivar a formação de professores para a educação básica, especialmente para o ensino médio, proporcionando a participação em experiências metodológicas e práticas docentes inovadoras. O PIBID antecipa o vínculo entre os futuros mestres e as salas de aula da rede pública e articula a educação superior (por meio das licenciaturas), a escola e os sistemas estaduais e municipais.\n" +
                        "\n" +
                        "O IFMG - Campus Bambuí parabeniza todos pela participação e os alunos Phelipe Góis e Rafael Oliveira pela premiação!" + "\n" + "Fonte: Professor Mayler Martins");
            }
            else if(noticiaAtual.getID() == 3){
                tituloAtual.setText(noticiaAtual.getTitulo());
                //textoAtual.setText(n1.getTexto());
                textoAtual.setText("É com satisfação que apresentamos a todos, o novo servidor que passa a integrar a equipe IFMG - Campus Bambuí:\n" +
                        "\nTécnico de Laboratório Rafael Pereira - Área: Biologia - Departamento de Ciências Agrárias.\n" +
                        "\n" +
                        "Reafirmamos nossas boas-vindas, para que possamos juntos engrandecer nossa Instituição como referência na Educação.\n" +
                        "\n" +
                        " \n" +
                        "Fonte: Coordenadoria de Gestão de Pessoas do IFMG - Campus Bambuí");
            }
            else if(noticiaAtual.getID() == 4){
                tituloAtual.setText(noticiaAtual.getTitulo());
                //textoAtual.setText(n1.getTexto());
                textoAtual.setText("O IFMG - Campus Bambuí divulga o Resultado Preliminar do Processo Seletivo 2018 de alunos regulares do Mestrado Profissional em Sustentabilidade e Tecnologia Ambiental (MPSTA).\n" +
                        "\n" +
                        "Confira: Resultado Preliminar\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Fonte: Secretaria do MPSTA - IFMG - Campus Bambuí");
            }
            else if(noticiaAtual.getID() == 5){
                tituloAtual.setText(noticiaAtual.getTitulo());
                //textoAtual.setText(n1.getTexto());
                textoAtual.setText("No dia 12 de dezembro de 2017, os alunos da disciplina de Gerência de Projetos do curso de Engenharia de Computação do IFMG - Campus Bambuí participaram de um seminário para apresentar os resultados de um projeto acadêmico desenvolvido ao longo de todo o semestre, junto a uma empresa da cidade de Bambuí.\n" +
                        "\n" +
                        "Neste projeto, o objetivo foi colocar em prática os conhecimentos adquiridos ao longo das disciplinas de programação, banco de dados e engenharia de software para entregar, de forma real, um sistema operante para um cliente. A parceria foi firmada com a Royal Scoth Bar que recebeu, além do sistema (que contou com website, ponto de venda, controle de pessoal e controle de estoque), suporte e seções de treinamento.\n" +
                        "\n" +
                        "O prof. Ciniro Nametala, que ministrou a disciplina, enfatizou a importância deste tipo de atividade dizendo que \"em muitas das vezes o que se aprende em sala de aula, especialmente em computação, não é levado para o campo. Muitas soluções úteis em informática estão desde cedo nas mãos dos nossos alunos e, por isso, é importante dar condições para que os mesmos disseminem o conhecimento e façam essa ligação entre escola e comunidade. Os alunos precisam saber da importância e do dever que eles têm em dar este retorno a sociedade, que na prática, é quem paga pela a formação deles\".\n" +
                        "\n" +
                        "O projeto desenvolvido levou em conta, também, diversos processos formais amplamente adotados em fábricas de software. Os alunos fundaram uma empresa fictícia chamada Soft Engenharia e, com esta, desenvolveram a captação do cliente, a assinatura dos termos de compromisso, reuniões, o levantamento de requisitos, atividades de análise e projeto de sistema, implementação, testes, implantação, treinamentos, suporte e gestão do projeto. Além disso, a fim de resguardar legalmente ambas as parte, foram assinadostermos e declarações acerca das condições impostas pela natureza estritamente acadêmica da atividade, sem qualquer vínculo empregatício ou financeiro.\n" +
                        "\n" +
                        "O aluno Harley Brito foi o responsável pela condução da equipe, atuando como Gerente de Projetos. Ao seu lado, o aluno Marco Antônio Gomes atuou como Analista Chefe, ajudando diretamente nas decisões estratégicas. Cada aluno, ao longo do processo, teve um papel específico dentro da fábrica de software." + "\n" + "Fonte: Professor Ciniro Nametala");
            }
            else{
                tituloAtual.setText(noticiaAtual.getTitulo());
                //textoAtual.setText(n1.getTexto());
                textoAtual.setText("Na tarde do dia 06 dezembro, no bosque do Museu Institucional, professores, gestores e alunos participaram do Plantio da Árvore que simboliza a Formatura de janeiro/2017. Participaram os concluintes dos cursos técnicos integrados em Agropecuária, em Informática, em Manutenção Automotiva e em Meio Ambiente.\n" +
                        "\n" +
                        "A simbologia desse momento é uma alusão ao próprio desenvolvimento de uma árvore: marca o fim de uma etapa e talvez o mais importante - o início de uma nova.\n" +
                        "\n" +
                        "O plantio de uma árvore poderá ser também a referência para todos quando retornarem o Campus. Referência de boas lembranças, de amizades, de pessoas que marcaram, de dificuldades superadas.\n" +
                        "\n" +
                        "A formanda Thais Cristine, do curso Técnico em Meio Ambiente, foi a oradora da cerimônia e ressaltou, em suas palavras, que “esta muda que neste momento está sendo plantada foi fruto de nosso aprendizado, o qual está representando todas as turmas formandas. Uma planta que ainda irá crescer e que dela brotará galhos que irão seguir rumos diferentes. Mas que jamais poderão seguir em frente sem antes ter passado por um processo de desenvolvimento.”\n" +
                        "\n" +
                        "O formando Lucas Lima agradeceu, em nome de todos os concluintes, aos professores que estiveram com eles nesta caminhada acadêmica, aos familiares e a todos que os apoiaram. Aproveitou o momento e fez um agradecimento especial à Prof.ª Adriana Teixeira, pelos seus ensinamentos, pela pessoa especial que é, pelo seu carinho e pelo seu apoio de sempre. \n" +
                        "\n" +
                        "Após a homenagem, surpreendeu a professora, convidando-a para ser a Paraninfa das turmas. Emocionada, a Profª Adriana disse SIM, e foi abraçada pelos formandos, que ficaram muito felizes." + "\n" + "Fonte: Coordenadoria de Eventos ");
            }
        }else{
            tituloAtual.setText("vazio");
            textoAtual.setText("vazio");
        }

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

                Intent intent = new Intent(getApplicationContext(), TesteWebServiceActivity.class);
                startActivity(intent);
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
