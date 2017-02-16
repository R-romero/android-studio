package br.com.fiap.romero.r.tabuada_ecologica;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainPage extends AppCompatActivity {

    private TextView txtNum1;
    private TextView txtNum2;
    private EditText resposta;
    private ImageView[] imgGarrafa = new ImageView[4];

    private int num1, num2;
    private int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        txtNum1 = (TextView) findViewById(R.id.num1);
        txtNum2 = (TextView) findViewById(R.id.num2);
        resposta = (EditText) findViewById(R.id.edtResposta);

        imgGarrafa[0] = (ImageView) findViewById(R.id.imgGarrafa0);
        imgGarrafa[1] = (ImageView) findViewById(R.id.imgGarrafa1);
        imgGarrafa[2] = (ImageView) findViewById(R.id.imgGarrafa2);
        imgGarrafa[3] = (ImageView) findViewById(R.id.imgGarrafa3);

        sortear();

    }

    private void sortear(){
        Random r = new Random();
        num1 = r.nextInt(9) + 1;
        num2 = r.nextInt(9) + 1;

        txtNum1.setText(String.valueOf(num1));
        txtNum2.setText(String.valueOf(num2));
        resposta.setText("");
    }

    public void conferir(View v){
        String resp = resposta.getText().toString();

        if(pontos == (imgGarrafa.length -1)){

            Toast.makeText(this, R.string.msgVencedor, Toast.LENGTH_SHORT).show();{

                this.imgGarrafa[pontos].setImageResource(android.R.drawable.screen_background_light_transparent);
                this.pontos = 0;
                this.imgGarrafa[pontos].setImageResource(R.drawable.garrafa);
            }
        }else{
            if(resp.equals(String.valueOf(num1 * num2))) {
                marcarPonto();
            }
        }
        sortear();
    }

    public void marcarPonto(){
        this.imgGarrafa[pontos].setImageResource(android.R.drawable.screen_background_light_transparent);
        this.pontos++;
        this.imgGarrafa[pontos].setImageResource(R.drawable.garrafa);
    }
}
