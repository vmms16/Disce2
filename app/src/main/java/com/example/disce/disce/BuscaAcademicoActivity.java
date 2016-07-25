package com.example.disce.disce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Vinicius on 22/07/2016.
 */
public class BuscaAcademicoActivity extends AppCompatActivity {
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

        wv.loadUrl("https://scholar.google.com.br/scholar?hl=pt-BR&q="+buscaString+"&btnG=&lr=");


    }
}
