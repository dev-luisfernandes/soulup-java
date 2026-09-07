package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProdutosDao {

    public Connection minhaConexao;

    public ProdutosDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Produtos produto) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into TB_SOUL_PRODUTOS values (?,?,?,?,?)");
        stmt.setInt(1, produto.getId());
        stmt.setString(2, produto.getNome());
        stmt.setInt(3, produto.getQuantidade());
        stmt.setString(4, produto.getTipo());
        stmt.setDouble(5, produto.getPontos());
        stmt.execute();
        stmt.close();
        return "Produto Cadastrado com Sucesso!!!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From TB_SOUL_PRODUTOS where ID =?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
        return "Produto Deletado com Sucesso!!!";
    }
}
