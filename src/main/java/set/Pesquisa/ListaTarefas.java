package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        for (Tarefa tarefa : tarefaSet) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = tarefa;
                break;
            }
        }
        tarefaSet.remove(tarefaParaRemover);
    }

    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }

    public int contarTarefas() {
        System.out.println(tarefaSet.size() + " tarefa(s).");
        return tarefaSet.size();
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setCompleted(true);
                return;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t: tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setCompleted(false);
                return;
            }
        }
    }

    public void obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : tarefaSet) {
            if (tarefa.isCompleted()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        System.out.println(tarefasConcluidas);
    }

    public void obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : tarefaSet) {
            if (!tarefa.isCompleted()) {
                tarefasPendentes.add(tarefa);
            }
        }
        System.out.println(tarefasPendentes);
    }

    public void limparListaTarefas() {
        Set<Tarefa> todasAsTarefas = new HashSet<>(tarefaSet);
        tarefaSet.removeAll(todasAsTarefas);
        System.out.println("Lista de tarefas limpadas.");
    }

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();
        lista.adicionarTarefa("comer");
        lista.adicionarTarefa("correr");
        lista.adicionarTarefa("ir à academia");
        lista.marcarTarefaConcluida("comer");
        lista.contarTarefas();
        lista.exibirTarefas();
        lista.removerTarefa("comer");
        lista.exibirTarefas();
    }

}
