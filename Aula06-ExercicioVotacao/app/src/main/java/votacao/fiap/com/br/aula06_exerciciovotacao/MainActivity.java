package votacao.fiap.com.br.aula06_exerciciovotacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private List<Candidato> prefeitos;
    private List<Candidato> vereadores;
    private ArrayAdapter<Candidato> adpPrefeito;
    private ArrayAdapter<Candidato> adpVereador;

    private Spinner spPrefeitos;
    private Spinner spVereadores;

    private RadioGroup rgCargo;

    private Button btnVotar;

    private TextView txtPrefeito;
    private TextView txtVereador;

    private String cargo;
    private String nome;



    private void criaPrefeitos(){
        prefeitos = new ArrayList<Candidato>();
        prefeitos.add(new Candidato("Zé da Feira","XTC"));
        prefeitos.add(new Candidato("Maria Melhor","LLL"));
        prefeitos.add(new Candidato("Brandão Filho","ZTO"));
    }
    private void criaVereadores(){
        vereadores = new ArrayList<Candidato>();
        vereadores.add(new Candidato("Joana Nascimento","XTC"));
        vereadores.add(new Candidato("Lucio Dalla Pimenta", "LLL"));
        vereadores.add(new Candidato("Mariano Maria", "ZTO"));
    }
    private void populaSpinnerPrefeitos(){
        adpPrefeito = new ArrayAdapter<Candidato>(this,android.R.layout.simple_spinner_item,this.prefeitos);
        spPrefeitos.setAdapter(adpPrefeito);
    }
    private void populaSpinnerVereadores(){
        adpVereador = new ArrayAdapter<Candidato>(this,android.R.layout.simple_spinner_item,this.vereadores);
        spVereadores.setAdapter(adpVereador);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spPrefeitos = (Spinner) findViewById(R.id.listaPrefeitoVereador);
        spPrefeitos.setOnItemSelectedListener(this);
        spVereadores = (Spinner) findViewById(R.id.listaPrefeitoVereador);
        spVereadores.setOnItemSelectedListener(this);
        rgCargo = (RadioGroup) findViewById(R.id.rgCargo);
        btnVotar = (Button) findViewById(R.id.btnVoltar);
        txtPrefeito = (TextView) findViewById(R.id.txtSelecaoPrefeito);
        txtVereador = (TextView) findViewById(R.id.txtSelecaoVereador);
        rgCargo.setOnCheckedChangeListener(this);
        criaPrefeitos();
        criaVereadores();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        selecionaLista();
    }

    private void selecionaLista() {
        int car = this.rgCargo.getCheckedRadioButtonId();
        if (car == R.id.rbPrefeito) {
            populaSpinnerPrefeitos();
            cargo = "PREFEITO";
        }else if (car == R.id.rbVereador){
            populaSpinnerVereadores();
            cargo = "VEREADOR";
        }

    }

    public void registraCandidato(View v){

        int sel = this.rgCargo.getCheckedRadioButtonId();
            if (sel == R.id.rbPrefeito){
               Toast.makeText(this, "Prefeito selecionado", Toast.LENGTH_LONG).show();
               txtPrefeito.setText("Prefeito: " + nome);
            }else if (sel == R.id.rbVereador){
               Toast.makeText(this, "Vereador selecionado", Toast.LENGTH_LONG).show();
                txtVereador.setText("Vereador: " + nome);
            }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Candidato sel = (Candidato) parent.getItemAtPosition(position);
        if (cargo.equals("PREFEITO")){
            this.nome=sel.getNome();
        }else if (cargo.equals("VEREADOR")){
            this.nome=sel.getNome();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
