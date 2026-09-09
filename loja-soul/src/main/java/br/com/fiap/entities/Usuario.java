package br.com.fiap.entities;

public class Usuario {

    private int CPF;
    private String nome;
    private double pontos;
    private int CEP;

    public Usuario() {
    }

    public Usuario(int CPF, String nome, double pontos, int CEP) {
        this.CPF = CPF;
        this.nome = nome;
        this.pontos = pontos;
        this.CEP = CEP;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
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

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "CPF=" + CPF +
                ", nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", CEP=" + CEP +
                '}';
    }
}
