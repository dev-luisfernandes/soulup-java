package br.com.fiap.main.produto;

import br.com.fiap.dao.ProdutosDao;
import br.com.fiap.entities.Produtos;
import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarProdutos {

    static int inteiro(String j) { return Integer.parseInt(JOptionPane.showInputDialog(j)); }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Produtos objProdutos = new Produtos();
        ProdutosDao dao = new ProdutosDao();

        objProdutos.setId(inteiro("Informe o ID que será deletado"));
        System.out.println(dao.deletar(objProdutos.getId()));
    }
}