package br.com.fiap.main.usuario;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entities.Usuario;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteInserirUsuario {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }
    static double real(String j){
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Usuario objUsuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();

        /*private String CPF;
    private String nome;
    private double pontos;
    private String telefone;
    private String email;
    private String dataNascimento;*/

        objUsuario.setCPF(texto("Digite o CPF nesse formato: (xxxxxxxxxx):"));
        objUsuario.setNome(texto("Nome do Usuário:"));
        objUsuario.setPontos(real("Pontuação Inicial (ex: 0):"));
        objUsuario.setTelefone(texto("Digite o numero ex:' (xx)xxxxxxxxx ':"));
        objUsuario.setEmail(texto("digite o email:"));
        objUsuario.setDataNascimento(texto("digite a data de nascimento no formato DD/MM/AA "));
        objUsuario.setSituacao(texto("Digite a Situação (ex: ATIVO / INATIVO):").toUpperCase());

        // Envia para o banco e mostra a mensagem de sucesso no meio da tela
        JOptionPane.showMessageDialog(
                null, dao.inserir(objUsuario));
    }
}