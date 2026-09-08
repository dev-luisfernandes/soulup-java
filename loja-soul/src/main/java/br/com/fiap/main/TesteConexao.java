package br.com.fiap.main;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //o conection é oq faz a conexão entre o java e o oracle depois
        //pego o metodo la do ConexaoFactory() uso o metodo de (conexao() ) que eu criei para integrar
        Connection conex = new ConexaoFactory().conexao();
        // se o de cima deu certo ele aparece a mensagem
        System.out.println("conexão correu bem ");

        //fecha o bd
        conex.close();
    }
}