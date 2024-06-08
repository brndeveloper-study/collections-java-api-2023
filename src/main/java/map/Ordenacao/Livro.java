package main.java.map.Ordenacao;

public class Livro implements Comparable<Livro>{
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Livro l) {
        return Double.compare(this.getPreco(), l.getPreco());
    }
}
