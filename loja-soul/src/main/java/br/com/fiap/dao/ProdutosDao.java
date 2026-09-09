package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDao {

    public Connection minhaConexao;

    public ProdutosDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Produtos produto) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO tb_recompensas (nome_recompensa, quantidade_estoque, tipo_recompensa, custo_pontos) VALUES (?, ?, ?, ?)");

        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getQuantidade());
        stmt.setString(3, produto.getTipo());
        stmt.setDouble(4, produto.getPontos());

        stmt.execute();
        stmt.close();
        return "Produto Cadastrado com Sucesso!!!";
    }

    public String atualizar(Produtos produto) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE tb_recompensas SET nome_recompensa = ?, quantidade_estoque = ?, tipo_recompensa = ?, custo_pontos = ? WHERE recompensa_id = ?");

        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getQuantidade());
        stmt.setString(3, produto.getTipo());
        stmt.setDouble(4, produto.getPontos());
        stmt.setInt(5, produto.getId());

        stmt.executeUpdate();
        stmt.close();
        return "Produto Atualizado com Sucesso!!!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM tb_recompensas WHERE recompensa_id = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
        return "Produto Deletado com Sucesso!!!";
    }

    public Produtos buscarPorId(int id) throws SQLException {
        Produtos produto = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tb_recompensas WHERE recompensa_id = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            produto = new Produtos();
            produto.setId(rs.getInt(1));          // recompensa_id
            produto.setNome(rs.getString(2));        // nome_recompensa
            produto.setQuantidade(rs.getInt(3));     // quantidade_estoque
            produto.setTipo(rs.getString(4));        // tipo_recompensa
            produto.setPontos(rs.getDouble(5));      // custo_pontos
        }
        rs.close();
        stmt.close();
        return produto;
    }

    public ArrayList<Produtos> selecionar() throws SQLException {
        ArrayList<Produtos> listaProdutos = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tb_recompensas");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produtos produto = new Produtos();
            produto.setId(rs.getInt(1));          // recompensa_id
            produto.setNome(rs.getString(2));        // nome_recompensa
            produto.setQuantidade(rs.getInt(3));     // quantidade_estoque
            produto.setTipo(rs.getString(4));        // tipo_recompensa
            produto.setPontos(rs.getDouble(5));      // custo_pontos
            listaProdutos.add(produto);
        }
        rs.close();
        stmt.close();
        return listaProdutos;
    }
}