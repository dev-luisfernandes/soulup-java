package br.com.fiap.entities;

public class Produtos {

    private String nome;
    private int quantidade;
    private String tipo;
    private double preco;

    public Produtos() {
    }

    public Produtos(String nome, int quantidade, String tipo, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\n\n--Produtos--" +
                "\nNome = " + nome +
                "\nQuantidade = " + quantidade +
                "\nTipo = " + tipo +
                "\nPreço = " + preco;
    }
}