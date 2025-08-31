package questao1.algoritmos;

public class MergeSort {
    public static void ordenar(int[] array) {
        ordenar(array, 0, array.length - 1);
    }

    private static void ordenar(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            ordenar(array, inicio, meio);
            ordenar(array, meio + 1, fim);

            mesclar(array, inicio, meio, fim);
        }
    }

    private static void mesclar(int[] array, int inicio, int meio, int fim) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];

        System.arraycopy(array, inicio, esquerda, 0, tamanhoEsquerda);
        System.arraycopy(array, meio + 1, direita, 0, tamanhoDireita);

        int i = 0, j = 0;
        int k = inicio;
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < tamanhoEsquerda) {
            array[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < tamanhoDireita) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }
}