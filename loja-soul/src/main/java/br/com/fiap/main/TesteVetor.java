package br.com.fiap.main;

import br.com.fiap.entities.Produtos;

import javax.swing.*;


public class TesteVetor {

    // static String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    // static int
    static int inteiro(String j){
        return Integer.parseInt( JOptionPane.showInputDialog(j) );
    }

    // static double
    static double real(String j){
        return Double.parseDouble( JOptionPane.showInputDialog(j) );
    }

    public static void main(String[] args) {

        // vetor de remédios determina a quantidade máxima de produtos a serem adicionados a lista
        Produtos[] vetorProdutos = new Produtos[3];  // [0] [1] [2]

        // índice para controlar a alocação de remédio nos vetores
        int indice = 0;

        // Laço de repetição          do  / while
        //                            faça / enquanto
        do{
            // Entradas - String nome, int quantidade, String tipo, double preco
            vetorProdutos[indice] = new Produtos();
            vetorProdutos[indice].setNome(texto("Nome"));
            vetorProdutos[indice].setQuantidade(inteiro("Quantidade"));
            vetorProdutos[indice].setTipo(texto("Tipo"));
            vetorProdutos[indice].setPreco(real("Preço"));

            // Adiciona + 1 no valor do índice
            indice++;

        }while ( JOptionPane.showConfirmDialog(
                null,
                "Adicionar mais Produtos?",
                "--Loja Soul-*-",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) ==0);

        // Saídas utilizando for
        for(int buscar =0; buscar < indice; buscar++){
            System.out.println(
                    vetorProdutos[buscar].toString()
            );
        }
    }
}