package main.java.list.Ordenacao;

import java.util.Comparator;

public class Cliente implements Comparable<Cliente> {
    private String nome;
    private int idade;
    private String sexo;

    public Cliente(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    @Override
    public int compareTo(Cliente cliente) {
        return Integer.compare(this.idade, cliente.getIdade());
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                "}\n";
    }
}

class ComparatorPorNome implements Comparator<Cliente> {

    @Override
    public int compare(Cliente p1, Cliente p2) {
        return p1.getNome().compareToIgnoreCase(p2.getNome());
    }
}
