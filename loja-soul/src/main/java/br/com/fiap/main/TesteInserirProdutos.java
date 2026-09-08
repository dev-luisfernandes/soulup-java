package br.com.fiap.main;
import javax.swing.JOptionPane;


public class TesteInserirProdutos {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j); }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j)); }
    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j)); }

}