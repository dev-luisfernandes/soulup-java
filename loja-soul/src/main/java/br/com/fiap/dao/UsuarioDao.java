package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    public Connection minhaConexao;

    public UsuarioDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    /*
    *
    private String CPF;
    private String nome;
    private double pontos;
    private String telefone;
    private String email;
    private String dataNascimento;

    * */

    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into TB_SOUL_USUARIOS values (?,?,?,?,?,?)");
        stmt.setString(1, usuario.getCPF()); //
        stmt.setString(2, usuario.getNome());
        stmt.setDouble(3, usuario.getPontos());
        stmt.setString(4, usuario.getTelefone());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getDataNascimento());

        stmt.execute();
        stmt.close();
        return "Usuário Cadastrado com Sucesso!!!";
    }

    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Update TB_SOUL_USUARIOS set NOME =?, PONTOS =?, TELEFONE =?, EMAIL =?, NASCIMENTO =? where CPF =?");
        stmt.setString(1, usuario.getCPF()); //
        stmt.setString(2, usuario.getNome());
        stmt.setDouble(3, usuario.getPontos());
        stmt.setString(4, usuario.getTelefone());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getDataNascimento());

        stmt.executeUpdate();
        stmt.close();
        return "Usuário Atualizado com Sucesso!!!";
    }

    public String deletar(String cpf) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From TB_SOUL_USUARIOS where CPF =?");
        stmt.setString(1, cpf);
        stmt.execute();
        stmt.close();
        return "Usuário Deletado com Sucesso!!!";
    }

    public Usuario buscarPorCpf(String cpf) throws SQLException {
        Usuario usuario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("Select * from TB_SOUL_USUARIOS where CPF=?");
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            /*
    *
    private String CPF;
    private String nome;
    private double pontos;
    private String telefone;
    private String email;
    private String dataNascimento;

    * */
            usuario = new Usuario();
            usuario.setCPF(rs.getString(1));
            usuario.setNome(rs.getString(2));
            usuario.setPontos(rs.getDouble(3));
            usuario.setTelefone(rs.getString(4));
            usuario.setEmail(rs.getString(5));
            usuario.setDataNascimento(rs.getString(6));
        }
        rs.close();
        stmt.close();
        return usuario;
    }

    public ArrayList<Usuario> selecionar() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("Select * from TB_SOUL_USUARIOS");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario = new Usuario();
            usuario.setCPF(rs.getString(1));
            usuario.setNome(rs.getString(2));
            usuario.setPontos(rs.getDouble(3));
            usuario.setTelefone(rs.getString(4));
            usuario.setEmail(rs.getString(5));
            usuario.setDataNascimento(rs.getString(6));
            listaUsuarios.add(usuario);
        }
        rs.close();
        stmt.close();
        return listaUsuarios;
    }

    public String adicionarPontosEcologicos(String cpf, double pontosGanhos) throws SQLException {
        Usuario usuarioAtual = buscarPorCpf(cpf);

        //se o usuario não for null
        if (usuarioAtual != null) {
            //ele vai pegar o usuario atual e adicionar os pontos ganho e definir como novo salto
            double novoSaldo = usuarioAtual.getPontos() + pontosGanhos;
            //vai definir pontos para o usuario escolhido e colocar o novo saldo
            usuarioAtual.setPontos(novoSaldo);

            // 3. atualizar para salvar la no bd
            atualizar(usuarioAtual);

            return "Parabéns! Você ganhou " + pontosGanhos + " pontos. Seu novo saldo de pontos é de : " + novoSaldo;
        } else {
            return "Erro: Usuário não encontrado no sistema.";
        }
    }
}
