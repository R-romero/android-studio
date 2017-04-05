package votacao.fiap.com.br.aula06_exerciciovotacao;

/**
 * Created by logonrm on 30/03/2017.
 */

public class Candidato {

    private String nome;
    private String partido;

    public Candidato(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
    }

    public Candidato() {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    @Override
    public String toString(){
        return getNome() + " - " + getPartido();
    }


}
