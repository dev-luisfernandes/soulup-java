package br.com.fiap.main;

import br.com.fiap.entities.Produtos;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayList {

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

        // Preparar lista
        ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();

        // Preparar objeto
        Produtos objProdutos = null;

        // laço de repetição      do   / while
        //                        faça / enquanto
        do{
            // Entradas - String nome, int quantidade, String tipo, double preco
            objProdutos = new Produtos();
            objProdutos.setNome(texto("Nome"));
            objProdutos.setQuantidade(inteiro("Quantidade"));
            objProdutos.setTipo(texto("Tipo"));
            objProdutos.setPreco(real("Preço"));

            listaProdutos.add(objProdutos);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Adicionar mais produtos?",
                "--Loja Soul-*-",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) ==0);

        // Saídas utilizando o foreach
        for(Produtos p : listaProdutos){
            System.out.println(
                    p.toString()
            );
        }
    }
}