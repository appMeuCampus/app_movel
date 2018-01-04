package com.example.a1513iron.app_meucampus_release1.Teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1513iron.app_meucampus_release1.R;

public class TesteWebServiceActivity extends AppCompatActivity {

    private TextView nome;
    private TextView sobrenome;
    private TextView email;
    private TextView endereco;
    private TextView cidade;
    private TextView estado;
    private TextView username;
    private TextView senha;
    private TextView nascimento;
    private TextView telefone;
    private ImageView foto;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);

        GetJson download = new GetJson();

        nome = (TextView) findViewById(R.id.t_textView5);
        sobrenome = (TextView) findViewById(R.id.t_textView11);
        email = (TextView) findViewById(R.id.t_textView8);
        endereco = (TextView) findViewById(R.id.t_textView7);
        cidade = (TextView) findViewById(R.id.t_textView4);
        estado = (TextView) findViewById(R.id.t_textView3);
        username = (TextView) findViewById(R.id.t_textView2);
        senha = (TextView) findViewById(R.id.t_textView10);
        nascimento = (TextView) findViewById(R.id.t_textView9);
        telefone = (TextView) findViewById(R.id.t_textView12);
        foto = (ImageView) findViewById(R.id.t_imageView);

        //Chama Async Task
        download.execute();
    }

    private class GetJson extends AsyncTask<Void, Void, PessoaObj> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(TesteWebServiceActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected PessoaObj doInBackground(Void... params) {
            Utils util = new Utils();

            return util.getInformacao("https://randomuser.me/api/0.7");
        }

        @Override
        protected void onPostExecute(PessoaObj pessoa) {
            nome.setText(pessoa.getNome().substring(0, 1).toUpperCase() + pessoa.getNome().substring(1));
            sobrenome.setText(pessoa.getSobrenome().substring(0, 1).toUpperCase() + pessoa.getSobrenome().substring(1));
            email.setText(pessoa.getEmail());
            endereco.setText(pessoa.getEndereco());
            cidade.setText(pessoa.getCidade().substring(0, 1).toUpperCase() + pessoa.getCidade().substring(1));
            estado.setText(pessoa.getEstado());
            username.setText(pessoa.getUsername());
            senha.setText(pessoa.getSenha());
            nascimento.setText(pessoa.getNascimento());
            telefone.setText(pessoa.getTelefone());
            foto.setImageBitmap(pessoa.getFoto());
            load.dismiss();
        }
    }
}

