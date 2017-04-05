package com.example.logonrm.pizzaria;

/**
 * Created by logonrm on 09/03/2017.
 */

public class PizzaBean {

    String Sabor;

    double preco;

    int imagem;

    public PizzaBean(String sabor, double preco, int imagem) {
        Sabor = sabor;
        this.preco = preco;
        this.imagem = imagem;
    }

    public String getSabor() {
        return Sabor;
    }

    public void setSabor(String sabor) {
        Sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString(){
        return this.getSabor() + " R$" + this.getPreco() ;
    }

}
