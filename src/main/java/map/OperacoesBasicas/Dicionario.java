package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        dicionarioMap.remove(palavra);
    }

    public void exibirPalavras() {
        System.out.println(dicionarioMap);
    }

    public void pesquisarPorPalavra(String palavra) {
        System.out.println(dicionarioMap.get(palavra));
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("comer", "ato de ingerir uma comida");
        dicionario.adicionarPalavra("dormir", "ato de descansar por um longo tempo");
        dicionario.adicionarPalavra("andar", "ato de usar as pernas para locomoção");
        dicionario.exibirPalavras();
        dicionario.removerPalavra("comer");
        dicionario.exibirPalavras();
        dicionario.pesquisarPorPalavra("dormir");
    }

}
