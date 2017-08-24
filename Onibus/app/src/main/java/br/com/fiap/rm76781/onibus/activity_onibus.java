package br.com.fiap.rm76781.onibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_onibus extends AppCompatActivity {

    private EditText edtDistancia;
    private EditText edtLinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onibus);
        edtDistancia = (EditText) findViewById(R.id.edtDistancia);
        edtLinha = (EditText) findViewById(R.id.edtLinha);
    }

    public void iniciar(View v){
        Intent start = new Intent(this, OnibusService.class);
        start.putExtra("distancia", edtDistancia.getText().toString());
        start.putExtra("linha", edtLinha.getText().toString());
        startService(start);
    }

    public void parar(View v){
        Intent stop = new Intent(this, OnibusService.class);
        stopService(stop);
    }
}
