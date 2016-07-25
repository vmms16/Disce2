package com.example.disce.disce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.disce.disce.usuario.service.UsuarioService;

/**
 * Created by Vinicius on 21/06/2016.
 */
public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {
    UsuarioService usuarioService = new UsuarioService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button cadastrar = (Button) findViewById(R.id.cadastrarUsuario);
        cadastrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.cadastrarUsuario){

            EditText nome= (EditText) findViewById(R.id.nomeCadastro);
            EditText login= (EditText) findViewById(R.id.loginCadastro);
            EditText pass= (EditText) findViewById(R.id.passCadastro);
            EditText repass= (EditText) findViewById(R.id.repassCadastro);

            String nomeString= nome.getText().toString();
            String loginString= login.getText().toString();
            String passString= pass.getText().toString();
            String repassString= repass.getText().toString();

            try {
                usuarioService.cadastrar(nomeString, loginString, passString);
                Toast.makeText(this,"Cadastro realizado",2).show();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
