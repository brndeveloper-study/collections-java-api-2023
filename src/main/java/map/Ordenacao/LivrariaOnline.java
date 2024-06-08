package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> livrariaOnlineMap;

    public LivrariaOnline() {
        this.livrariaOnlineMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrariaOnlineMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        if (!livrariaOnlineMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livrariaOnlineMap.remove(entry.getKey());
                    return;
                }
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        //como o comparable/comparator do Map ele ordena as chaves, temos que ordenar os valores individualmente
        //sendo assim, iremos criar uma ArrayList dos valores do Map Original
        List<Livro> listaDeLivros = new ArrayList<>(livrariaOnlineMap.values());

        //agora a gente vai ordenar esses valores pelo preço, usando o comparable que implementamos na classe livro
        Collections.sort(listaDeLivros);

        //vamos criar agora o novo map que vai ser retornado
        Map<String, Livro> livrosOrdenadosPorPreco = null;

        if (!livrariaOnlineMap.isEmpty()) {
            livrosOrdenadosPorPreco = new LinkedHashMap<>(); // aqui foi preciso usar linkedhashmap pois a ordem do preço importava
            // vamos fazer agora a associação das chaves com valores usando 2 foreach
            for (Livro livro : listaDeLivros) {
                for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()) {
                    if (entry.getValue().equals(livro)) { // se o Livro do map original for igual à lista de livros que ja foi ordenada
                        livrosOrdenadosPorPreco.put(entry.getKey(), livro); // aqui estamos criando a associação de chave-valor
                        break; // quebramos aqui o if para ir para o próximo livro do map original para fazer a comparação
                    }
                }
            }
        }
        return livrosOrdenadosPorPreco;
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();;
        if (!livrariaOnlineMap.isEmpty()) {
            for (Livro l : livrariaOnlineMap.values()) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livro = null;
        Map<String, Livro> livrosOrdenadosPorPreco = new TreeMap<>(livrariaOnlineMap);
        double precoDoLivroMaisBarato = Double.MIN_VALUE;

        if (!livrariaOnlineMap.isEmpty()) {
            for (Livro l : livrosOrdenadosPorPreco.values()) {
                if (l.getPreco() > precoDoLivroMaisBarato) {
                    livro = l;
                    precoDoLivroMaisBarato = l.getPreco();
                }
            }
        }
        return livro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livro = null;
        Map<String, Livro> livrosOrdenadosPorPreco = new TreeMap<>(livrariaOnlineMap);
        double precoDoLivroMaisCaro = Double.MAX_VALUE;

        if (!livrariaOnlineMap.isEmpty()) {
            for (Livro l : livrosOrdenadosPorPreco.values()) {
                if (l.getPreco() < precoDoLivroMaisCaro) {
                    livro = l;
                    precoDoLivroMaisCaro = l.getPreco();
                }
            }
        }
        return livro;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        livrariaOnline.adicionarLivro("teste.com.br/livro1", "O teste", "Desconhecido", 25.50d);
        livrariaOnline.adicionarLivro("teste.com.br/livro2", "O teste 2", "Desconhecido", 30.00d);
        livrariaOnline.adicionarLivro("teste.com.br/livro3", "O teste 3", "Desconhecido", 40.00d);
        livrariaOnline.adicionarLivro("teste.com.br/livro4", "O teste 4", "Desconhecido", 35.00d);
        livrariaOnline.adicionarLivro("teste.com.br/livro5", "O teste 5: A redenção", "Conhecido", 99.90d);
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Desconhecido"));
        System.out.println(livrariaOnline.obterLivroMaisBarato());
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
    }

}
