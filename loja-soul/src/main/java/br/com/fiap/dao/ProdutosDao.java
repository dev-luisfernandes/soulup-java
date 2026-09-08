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
        // Tabela atualizada aqui
        //PreparedStatement é o que leva o sql do java para o oracle, ou seja, ele é o uber das informações
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
    public String atualizar(Produtos produto) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Update TB_SOUL_PRODUTOS set NOME =?, QUANTIDADE =?, TIPO =?, PONTOS =? where ID =?");
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
        // ele deleta da tabela que a gente criou, mas só o produto com o ID que bate, o id digitado na hora de excluir
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From TB_SOUL_PRODUTOS where ID =?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
        return "Produto Deletado com Sucesso!!!";}

    public Produtos buscarPorId(int id) throws SQLException {
        Produtos produto = null;
        // aq basicamente diz pra selecionar todas as colunas da tabela TB... porem só as informações do ID selecionado
        PreparedStatement stmt = minhaConexao.prepareStatement("Select * from TB_SOUL_PRODUTOS where ID=?");
        stmt.setInt(1, id);
        //resulset basicamente a resposta da oracle que fica armazenada no java,
        //rs é so a referencia pra n ficar digitando toda hora ResultSet
        ResultSet rs = stmt.executeQuery();
        //esse next serve para andar linha por linha dessa repsosta para extrair as informações
        if (rs.next()) {
            produto = new Produtos();
            produto.setId(rs.getInt(1));
            produto.setNome(rs.getString(2));
            produto.setQuantidade(rs.getInt(3));
            produto.setTipo(rs.getString(4));
            produto.setPontos(rs.getDouble(5));
        }
        rs.close();
        stmt.close();
        return produto;
    }
    public ArrayList<Produtos> selecionar() throws SQLException {

        ArrayList<Produtos> listaProdutos = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("Select * from TB_SOUL_PRODUTOS");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produtos produto = new Produtos();
            produto.setId(rs.getInt(1));
            produto.setNome(rs.getString(2));
            produto.setQuantidade(rs.getInt(3));
            produto.setTipo(rs.getString(4));
            produto.setPontos(rs.getDouble(5));
            listaProdutos.add(produto);
        }
        rs.close();
        stmt.close();
        return listaProdutos;
    }
}
