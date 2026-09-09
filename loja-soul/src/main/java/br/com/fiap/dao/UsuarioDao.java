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

    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Insert Into tb_usuarios (nome_usuario, cpf, email, telefone, data_nascimento, pontos, situacao) VALUES (?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getCPF());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getTelefone());
        stmt.setString(5, usuario.getDataNascimento());
        stmt.setDouble(6, usuario.getPontos());
        stmt.setString(7, usuario.getSituacao());

        stmt.execute();
        stmt.close();
        return "Usuário Cadastrado com Sucesso!!!";
    }

    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Update tb_usuarios set nome_usuario = ?, pontos = ?, telefone = ?, email = ?, situacao = ? where cpf = ?");

        stmt.setString(1, usuario.getNome());
        stmt.setDouble(2, usuario.getPontos());
        stmt.setString(3, usuario.getTelefone());
        stmt.setString(4, usuario.getEmail());
        stmt.setString(5, usuario.getSituacao());
        stmt.setString(6, usuario.getCPF());

        stmt.executeUpdate();
        stmt.close();
        return "Usuário Atualizado com Sucesso!!!";
    }

    public String deletar(String cpf) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From tb_usuarios where cpf =?");
        stmt.setString(1, cpf);
        stmt.execute();
        stmt.close();
        return "Usuário Deletado com Sucesso!!!";
    }

    public Usuario buscarPorCpf(String cpf) throws SQLException {
        Usuario usuario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement(
                /*TO_CHAR(data_nascimento, 'DD/MM/YYYY')
                * O TO_CHAR é uma função utilizada para converter valores
                * tipo datas ou números em texto (String), permitindo customizar o formato de exibição nesse cado (DD/MM/YYYY)*/
                "Select usuario_id, nome_usuario, cpf, email, telefone, TO_CHAR(data_nascimento, 'DD/MM/YYYY'), pontos, situacao from tb_usuarios where cpf=?"
        );
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setNome(rs.getString(2));
            usuario.setCPF(rs.getString(3));
            usuario.setEmail(rs.getString(4));
            usuario.setTelefone(rs.getString(5));
            usuario.setDataNascimento(rs.getString(6)); //aq ele ja vai vir certinho no formato
            usuario.setPontos(rs.getDouble(7));
            usuario.setSituacao(rs.getString(8));
        }
        rs.close();
        stmt.close();
        return usuario;
    }

    public ArrayList<Usuario> selecionar() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Select usuario_id, nome_usuario, cpf, email, telefone, TO_CHAR(data_nascimento, 'DD/MM/YYYY'), pontos, situacao from tb_usuarios"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString(2));
            usuario.setCPF(rs.getString(3));
            usuario.setEmail(rs.getString(4));
            usuario.setTelefone(rs.getString(5));
            usuario.setDataNascimento(rs.getString(6));
            usuario.setPontos(rs.getDouble(7));
            usuario.setSituacao(rs.getString(8));
            listaUsuarios.add(usuario);
        }
        rs.close();
        stmt.close();
        return listaUsuarios;
    }

    public String adicionarPontosEcologicos(String cpf, double pontosGanhos) throws SQLException {
        Usuario usuarioAtual = buscarPorCpf(cpf);

        if (usuarioAtual != null) {
            double novoSaldo = usuarioAtual.getPontos() + pontosGanhos;
            usuarioAtual.setPontos(novoSaldo);
            atualizar(usuarioAtual);

            return "Parabéns! Você ganhou " + pontosGanhos + " pontos. Seu novo saldo de pontos é de : " + novoSaldo;
        } else {
            return "Erro: Usuário não encontrado no sistema.";
        }
    }
}