package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Alunos> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAlunos(String nome, long matricula, double nota) {
        alunosSet.add(new Alunos(nome, matricula, nota));
    }

    public void removerAluno(long matricula) {
        for (Alunos aluno : alunosSet) {
            if (aluno.getMatricula() == matricula) {
                alunosSet.remove(aluno);
                return;
            }
        }
    }

    public Set<Alunos> exibirAlunosPorNome() {
        Set<Alunos> alunosPorNome = new TreeSet<>(alunosSet);
        return alunosPorNome;
    }

    public Set<Alunos> exibirAlunosPorNota() {
        Set<Alunos> alunosPorPreco = new TreeSet<>(new ComparatorPorNota());
        alunosPorPreco.addAll(alunosSet);
        return alunosPorPreco;
    }

    public Set<Alunos> exibirAlunos() {
        return alunosSet;
    }

    public static void main(String[] args) {
        GerenciadorAlunos alunosDo8ano = new GerenciadorAlunos();
        alunosDo8ano.adicionarAlunos("João", 2423423234L, 8.5);
        alunosDo8ano.adicionarAlunos("Fernando", 2423423423L, 5.5);
        alunosDo8ano.adicionarAlunos("Miguel", 24234423423L, 9.5);
        System.out.println(alunosDo8ano.exibirAlunosPorNota());
        System.out.println(alunosDo8ano.exibirAlunosPorNome());
        System.out.println(alunosDo8ano.exibirAlunos());
    }

}
