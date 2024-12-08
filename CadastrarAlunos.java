package ifma.lista01;

import java.util.Arrays;

public class CadastrarAlunos {
    private Aluno[] alunos;
    private int tamanhoAtual;

    public CadastrarAlunos(int tamanho) {
        alunos = new Aluno[tamanho];
        tamanhoAtual = 0;
    }

    public void adicionarNoFinal(Aluno aluno) {
        if (tamanhoAtual < alunos.length) {
            alunos[tamanhoAtual] = aluno;
            tamanhoAtual++;
        } else {
            System.out.println("Não há espaço disponível no vetor.");
        }
    }

    public void adicionarNoInicio(Aluno aluno) {
        if (tamanhoAtual < alunos.length) {
            for (int i = tamanhoAtual; i > 0; i--) {
                alunos[i] = alunos[i - 1];
            }
            alunos[0] = aluno;
            tamanhoAtual++;
        } else {
            System.out.println("Não há espaço disponível no vetor.");
        }
    }

    public void removerNoFinal() {
        if (tamanhoAtual > 0) {
            alunos[tamanhoAtual - 1] = null;
            tamanhoAtual--;
        } else {
            System.out.println("Não há alunos para remover.");
        }
    }

    public void removerNoInicio() {
        if (tamanhoAtual > 0) {
            for (int i = 0; i < tamanhoAtual - 1; i++) {
                alunos[i] = alunos[i + 1];
            }
            alunos[tamanhoAtual - 1] = null;
            tamanhoAtual--;
        } else {
            System.out.println("Não há alunos para remover.");
        }
    }

    public boolean verificarIndice(int indice) {
        return indice >= 0 && indice < tamanhoAtual && alunos[indice] != null;
    }

    public String removerComIndice(int indice) {
        if (verificarIndice(indice)) {
            String nomeRemovido = alunos[indice].getNome();
            if (indice == 0) {
                removerNoInicio();
            } else if (indice == tamanhoAtual - 1) {
                removerNoFinal();
            } else {
                for (int i = indice; i < tamanhoAtual - 1; i++) {
                    alunos[i] = alunos[i + 1];
                }
                alunos[tamanhoAtual - 1] = null;
                tamanhoAtual--;
            }
            return nomeRemovido;
        } else {
            throw new IllegalArgumentException("Índice inválido ou não ocupado por um Aluno.");
        }
    }

    public void ordenarVetor() {
        Arrays.sort(alunos, 0, tamanhoAtual, (a1, a2) -> Integer.compare(a1.getCodigo(), a2.getCodigo()));
    }

    public void listarAlunos() {
        for (int i = 0; i < tamanhoAtual; i++) {
            System.out.println("Código: " + alunos[i].getCodigo() + ", Nome: " + alunos[i].getNome());
        }
    }
}
