package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Util {
    private Fornecedor[] fornecedor = new Fornecedor[5];
    private Produto[] produtos = new Produto[7];
    private int idxFornecedor = 0;
    private int idxProduto = 0;

    public void menu() {
        int opcao;
        String aux = "1. Cadastrar produto\n" +
                "2. Pesquisar produto por nome\n" +
                "3. Pesquisar fornecedor por CNPJ\n" +
                "4. Finalizar";
        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao == 4)
                return;

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisar();
                    break;
                default:
                    showMessageDialog(null,"Valor invalido");
            }
        }
    }

    public void cadastrarProduto(){
        String nome;
        int qtdEstoque;
        double valor;
        Fornecedor fornecedor = pesquisarFornecedor();
        if (fornecedor==null)
            fornecedor = cadastrarFornecedor();

        nome = showInputDialog("Nome do produto");
        qtdEstoque=parseInt(showInputDialog("Quantos em estoque"));
        valor= parseDouble(showInputDialog("Valor unitario:"));
        produtos[idxProduto]=new Produto(nome,valor,qtdEstoque,fornecedor);
    };

    public void pesquisarProduto(){
        String aux="";
        String nometeste = showInputDialog("QAUL O NOME DO PRODUTO: ");
        for (int i = 0; i < idxFornecedor; i++) {
            if (nometeste.equalsIgnoreCase(produtos[i].getNome()));
            aux = ("Nome: " + produtos[i].getNome() + "\nvalor: " + produtos[i].getValor()+"\nFornecedor: " + produtos[i].getFornecedor());
        }
        showMessageDialog(null , aux);

    }

    public Fornecedor pesquisarFornecedor(){
        long cnpj= parseLong(showInputDialog("CNPJ DO FORNECEDOR:"));
        for (int i = 0; i < idxFornecedor; i++) {
            if (fornecedor[i].getCnpj()==cnpj)
                return fornecedor[i];
        }
        showMessageDialog(null,"CNPJ NAO ENCONTRADO");
        return null;
    }
    public Fornecedor cadastrarFornecedor(){
        long cnpj = parseLong(showInputDialog(null,"Digite seu cnpj"));
        String nome = showInputDialog(null, "Digite seu nome");
        fornecedor[idxFornecedor] = new Fornecedor(nome, cnpj);
        idxFornecedor++;
        return fornecedor[idxFornecedor-1];
    }
    public void pesquisar(){
        Fornecedor fornecedor = pesquisarFornecedor();
        if (fornecedor!=null){
            showMessageDialog(null, fornecedor.getCnpj()+ "\n" + fornecedor.getNome());
        }
    }
}
