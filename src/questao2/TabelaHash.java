package questao2;

public class TabelaHash {
    private No[] tabela;
    private int tamanho;

    public TabelaHash(int m) {
        this.tamanho = m;
        this.tabela = new No[m];
    }

    private int funcaoHash(int chave) {
        return chave % tamanho;
    }

    public boolean inserir(int valor) {
        if (buscar(valor)) {
            return false; // Elemento já existe
        }

        int indice = funcaoHash(valor);
        No novoNo = new No(valor);

        // Inserção no início da lista
        novoNo.proximo = tabela[indice];
        tabela[indice] = novoNo;

        return true;
    }

    public boolean buscar(int valor) {
        int indice = funcaoHash(valor);
        No atual = tabela[indice];

        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.proximo;
        }

        return false;
    }

    public boolean remover(int valor) {
        int indice = funcaoHash(valor);
        No atual = tabela[indice];
        No anterior = null;

        while (atual != null) {
            if (atual.valor == valor) {
                if (anterior == null) {
                    // Remove do início
                    tabela[indice] = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Posição " + i + ": ");
            No atual = tabela[i];

            if (atual == null) {
                System.out.print("Vazia");
            } else {
                while (atual != null) {
                    System.out.print(atual.valor);
                    if (atual.proximo != null) {
                        System.out.print(" → ");
                    }
                    atual = atual.proximo;
                }
            }
            System.out.println();
        }
    }
}