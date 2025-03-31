package br.fiap.produto;

import br.fiap.fornecedor.Fornecedor;

import javax.swing.*;

public class Produto {
    private String nome;
    private double valor;
    private int quant;
    private Fornecedor fornecedor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, double valor, int quant, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.quant = quant;
        this.fornecedor = fornecedor;
    }

}
