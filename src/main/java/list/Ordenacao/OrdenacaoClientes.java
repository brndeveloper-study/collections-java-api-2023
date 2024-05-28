package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoClientes {
    private List<Cliente> listaClientes;

    public OrdenacaoClientes() {
        this.listaClientes = new ArrayList<>();
    }

    public void adicionarCliente(String nome, int idade, String sexo) {
        listaClientes.add(new Cliente(nome, idade, sexo));
    }

    public void removerCliente(Cliente cliente) {
        if (listaClientes.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        Cliente clienteParaRemover = null;
        for (Cliente pessoa : listaClientes) {
            if (pessoa == cliente) {
                clienteParaRemover = pessoa;
            }
        }
        listaClientes.remove(clienteParaRemover);
    }

    public List<Cliente> ordenarClientesMaisVelhos() {
        List<Cliente> clientesPorIdade = new ArrayList<>(listaClientes);
        clientesPorIdade.sort(Collections.reverseOrder());
        return clientesPorIdade;
    }

    public static void main(String[] args) {
        OrdenacaoClientes clientes = new OrdenacaoClientes();

        clientes.adicionarCliente("Bruno", 21, "Masculino");
        clientes.adicionarCliente("Fernando", 51, "Masculino");
        clientes.adicionarCliente("Brenda", 27, "Feminino");
        System.out.println(clientes.ordenarClientesMaisVelhos());

    }

}
