package br.fiap.main;

import br.fiap.fornecedor.Fornecedor;

public class Main {
    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor("Pedro Henrique", 777);
        System.out.println(fornecedor.getNome());
        fornecedor.setNome("Matosaleu");
        System.out.println(fornecedor.getNome());
    }
}