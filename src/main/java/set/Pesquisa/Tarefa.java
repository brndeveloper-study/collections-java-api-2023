package main.java.set.Pesquisa;

public class Tarefa {
    //atributos
    private String descricao;
    private boolean isCompleted;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        if (isCompleted)
            return "{descrição: " + descricao + ", status: Completado}";
        return "{descrição: " + descricao + ", status: Não Completado}";
    }

}
