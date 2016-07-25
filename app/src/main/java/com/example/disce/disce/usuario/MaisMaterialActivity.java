package com.example.disce.disce.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.disce.disce.R;

/**
 * Created by Vinicius on 20/07/2016.
 */
public class MaisMaterialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceExtends){
        super.onCreate(savedInstanceExtends);
        setContentView(R.layout.activity_aula);

        Intent novaIntent = getIntent();
        Bundle busca= novaIntent.getExtras();
        String buscaString= busca.getString("busca");


        WebView wv = (WebView) findViewById(R.id.webview);

        WebSettings ws= wv.getSettings();

        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        wv.loadUrl("https://www.google.com.br/search?sclient=psy-ab&hl=pt-BR&site=webhp&source=hp&btnG=Pesquisar&q="+buscaString);


    }
}
