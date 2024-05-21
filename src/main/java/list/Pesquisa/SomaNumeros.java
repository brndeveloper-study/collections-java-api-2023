package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numerosInteiros;

    public SomaNumeros() {
        this.numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosInteiros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        if (!numerosInteiros.isEmpty()) {
            for (Integer numero : numerosInteiros) {
                soma += numero;
            }
        }

        return soma;
    }

    public int encontrarMaiorNumero() {
        int ultimoNumero = 0;

        if (!numerosInteiros.isEmpty()) {
            for (Integer numero : numerosInteiros) {
                if (numero > ultimoNumero) {
                    ultimoNumero = numero;
                }
            }
        }

        return ultimoNumero;
    }

    public int encontrarMenorNumero() {
        int ultimoNumero = 0;

        if (!numerosInteiros.isEmpty()) {
            ultimoNumero = numerosInteiros.get(0); //primeiro índice do arrayList

            for (Integer numero : numerosInteiros) {
                if (numero < ultimoNumero) {
                    ultimoNumero = numero;
                }
            }
        }

        return ultimoNumero;
    }

    public List<Integer> exibirNumeros() {
        return numerosInteiros;
    }

    public static void main(String[] args) {
        SomaNumeros somadorDeNumeros = new SomaNumeros();

        somadorDeNumeros.adicionarNumero(34);
        somadorDeNumeros.adicionarNumero(87);
        somadorDeNumeros.adicionarNumero(54);
        somadorDeNumeros.adicionarNumero(27);
        System.out.println("Soma total: " + somadorDeNumeros.calcularSoma());
        System.out.println(somadorDeNumeros.exibirNumeros());
        System.out.println("Maior número: " + somadorDeNumeros.encontrarMaiorNumero());
        System.out.println("Menor número: " + somadorDeNumeros.encontrarMenorNumero());

    }
}
