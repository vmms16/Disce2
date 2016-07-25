package com.example.disce.disce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.disce.disce.usuario.MaisMaterialActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Button material= (Button) findViewById(R.id.material);
        material.setOnClickListener(this);*/

        Button assistir= (Button) findViewById(R.id.assistir);
        assistir.setOnClickListener(this);

        Button buscaMaterial= (Button) findViewById(R.id.buscamaterial);
        buscaMaterial.setOnClickListener(this);

        /*Button buscaAcademico= (Button) findViewById(R.id.buscamaterialacademico);
        buscaAcademico.setOnClickListener(this);*/




    }


    @Override
    public void onClick(View v) {

       /* if(v.getId()==R.id.material){
            Intent intent= new Intent(getApplicationContext(),MaterialActivity.class);
            startActivity(intent);
        } */

        if(v.getId()==R.id.assistir){
            EditText busca= (EditText) findViewById(R.id.busca);
            String buscaString= busca.getText().toString();
            Intent intent = new Intent(getApplicationContext(), AulaActivity.class);
            intent.putExtra("busca",buscaString);
            startActivity(intent);
        }

        if(v.getId()==R.id.buscamaterial){
            EditText busca= (EditText) findViewById(R.id.busca);
            String buscaString= busca.getText().toString();
            Intent intent = new Intent(getApplicationContext(), MaisMaterialActivity.class);
            intent.putExtra("busca",buscaString);
            startActivity(intent);

        }


    }
}
