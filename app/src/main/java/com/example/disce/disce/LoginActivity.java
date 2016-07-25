package com.example.disce.disce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.disce.disce.usuario.service.UsuarioService;

/**
 * Created by Vinicius on 18/06/2016.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    UsuarioService usuarioService=new UsuarioService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView cadastrar= (TextView) findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(this);

        Button logar= (Button) findViewById(R.id.logar);
        logar.setOnClickListener(this);

    }

   /* public void onButtonClick(View view){
        if(view.getId()==R.id.logar){
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        else if(view.getId()==R.id.cadastrar){
            Intent intent=new Intent(getApplicationContext(),CadastroActivity.class);
            startActivity(intent);
        }
    }
    */

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.logar){

            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

           /* EditText login= (EditText) findViewById(R.id.login);
            EditText pass= (EditText) findViewById(R.id.pass);

            String loginString = login.getText().toString();
            String passString= pass.getText().toString();

            try {

                UsuarioDominio usuario= usuarioService.login(loginString, passString);
                if (usuario!=null){
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"Usuario ou login inavalidos",5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/

        }

        else if(v.getId()==R.id.cadastrar){
            Intent intent=new Intent(getApplicationContext(),CadastroActivity.class);
            startActivity(intent);
        }

    }
}
