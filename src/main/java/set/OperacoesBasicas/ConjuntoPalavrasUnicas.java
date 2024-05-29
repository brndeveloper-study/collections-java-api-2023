package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (palavrasUnicas.isEmpty()) {
            System.out.println("O conjunto está vazio!");
            return;
        }
        palavrasUnicas.remove(palavra);
    }

    public void verificarPalavra(String palavra) {
        for (String p : palavrasUnicas) {
            if (p.equalsIgnoreCase(palavra)) {
                System.out.println("'" + palavra + "' encontrada.");
                return;
            }
        }
        System.out.println("A palavra '" + palavra + "' não foi encontrada.");
    }

    public void exibirPalavrasUnicas() {
        if (palavrasUnicas.isEmpty()) {
            System.out.println("O conjunto está vazio!");
            return;
        }
        System.out.println("Conjunto:");
        for (String p : palavrasUnicas) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
        conjuntoPalavrasUnicas.verificarPalavra("cenoura");
        conjuntoPalavrasUnicas.adicionarPalavra("cenoura");
        conjuntoPalavrasUnicas.adicionarPalavra("limão");
        conjuntoPalavrasUnicas.verificarPalavra("limão");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
        conjuntoPalavrasUnicas.removerPalavra("limão");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

    }

}
