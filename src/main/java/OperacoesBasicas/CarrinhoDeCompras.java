package main.java.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributo, que é uma lista de items da classe Item.
    private List<Item> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        // criando uma Lista do mesmo tipo
        List<Item> itensParaRemover = new ArrayList<>();

        // for-each para entrar no carrinho, se o nome a cada iteração for igual ao nome
        // mandado no argumento, ele vai adicionar na lista que foi criada para remover
        for (Item item : carrinho) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(item);
            }
        }

        //aqui o carrinho vai remover os itens com base na lista dos itens criados para remover
        carrinho.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double soma = 0;
        for (Item item : carrinho) {
            soma += item.getPreco();
        }
        return soma;
    }

    public void exibirItens() {
        System.out.println(carrinho);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("mamão", 3.55, 3);
        carrinho.adicionarItem("melancia", 5.55, 5);
        carrinho.exibirItens();
        System.out.println("Valor total é: R$" + carrinho.calcularValorTotal());
    }

}
