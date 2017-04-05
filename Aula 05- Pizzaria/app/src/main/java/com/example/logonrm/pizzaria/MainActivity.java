package com.example.logonrm.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private List<PizzaBean> pizzas;
    private ArrayAdapter<PizzaBean> adpSabor;
    private Spinner spSabor;
    private ImageView imgPizza;
    private RadioGroup rgTamanho;
    private CheckBox borda;

    private PizzaBean pizzaSelecionada;
    private int tamanhoSelecionado;
    private boolean bordaSelecionada;

    private TextView txtPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spSabor = (Spinner) findViewById(R.id.spSabor);
        imgPizza = (ImageView) findViewById(R.id.imgPizza);
        obterPizza();
        exibirSabores();
        spSabor.setOnItemSelectedListener(this);
        rgTamanho = (RadioGroup)findViewById(R.id.rgTamanho);
        rgTamanho.setOnCheckedChangeListener(this);
        borda = (CheckBox) findViewById(R.id.chkBorda);
        txtPreco = (TextView) findViewById(R.id.txtPreco);


    }

    private void obterPizza(){

        pizzas = new ArrayList<PizzaBean>();
        pizzas.add(new PizzaBean("Bacon",35.0,R.drawable.pizzabacon));
        pizzas.add(new PizzaBean("Carbonara",39.0,R.drawable.pizzacarbonara));
        pizzas.add(new PizzaBean("Pancia de Nono",49.90,R.drawable.pizzapancianono));
        pizzas.add(new PizzaBean("Queijo",25.0,R.drawable.pizzaqueijo));
    }

    private void exibirSabores(){
        adpSabor = new ArrayAdapter<PizzaBean>(this,android.R.layout.simple_spinner_item,pizzas);
        spSabor.setAdapter(adpSabor);
    }

    private void adicionarSabor(){
        pizzas.add(new PizzaBean("Rucula",39.90,R.drawable.pizzarucula));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        PizzaBean sel = (PizzaBean) parent.getItemAtPosition(position);
        Toast.makeText(this,sel.getSabor(),Toast.LENGTH_SHORT).show();
        imgPizza.setImageResource(sel.getImagem());
        calcularPreco();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void calcularPreco(){

        double preco = this.pizzaSelecionada.getPreco();
        if (this.tamanhoSelecionado == R.id.rbPequeno){
            preco += 5.0;
        }else if (this.tamanhoSelecionado == R.id.rbMedio){
            preco += 10.0;

        }else if(this.tamanhoSelecionado == R.id.rbGrande){
            preco += 15.0;
        }


        if (this.bordaSelecionada){
            preco +=5.0;
        }

        txtPreco.setText(String.valueOf(preco));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
         calcularPreco();

    }

    public void borda(View v){

        this.bordaSelecionada = borda.ischecked();
        calcularPreco();

        if (borda.isChecked()){


        }

    }

}
