package br.com.fiap.entities;

public class Usuario {

    private String CPF;
    private String nome;
    private double pontos;
    private String telefone;
    private String email;
    private String dataNascimento;

    public Usuario() {
    }

    public Usuario(String CPF, String nome, double pontos, String telefone, String email, String dataNascimento) {
        this.CPF = CPF;
        this.nome = nome;
        this.pontos = pontos;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "CPF='" + CPF + '\'' +
                ", nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}