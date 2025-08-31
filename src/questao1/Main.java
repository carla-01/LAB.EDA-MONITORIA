package questao1;

import java.util.function.Consumer;
import questao1.algoritmos.*;
import questao1.modelo.Resultado;
import questao1.util.Cronometro;
import questao1.util.GeradorArray;

public class Main {
    private static final int NUM_EXECUCOES = 10;
    private static final int TAMANHO_PEQUENO = 20;
    private static final int TAMANHO_GRANDE = 2000;

    public static void main(String[] args) {
        // Gerar arrays de tamanho 20
        int[] array20Crescente = GeradorArray.gerarArrayCrescente(TAMANHO_PEQUENO);
        int[] array20Decrescente = GeradorArray.gerarArrayDecrescente(TAMANHO_PEQUENO);
        int[] array20Aleatorio = GeradorArray.gerarArrayAleatorio(TAMANHO_PEQUENO);

        // Gerar arrays de tamanho 2000
        int[] array2000Crescente = GeradorArray.gerarArrayCrescente(TAMANHO_GRANDE);
        int[] array2000Decrescente = GeradorArray.gerarArrayDecrescente(TAMANHO_GRANDE);
        int[] array2000Aleatorio = GeradorArray.gerarArrayAleatorio(TAMANHO_GRANDE);

        // Testar os algoritmos
        Resultado resultadoInsertion = testarInsertionSort(array20Crescente, array20Decrescente, array20Aleatorio,
                array2000Crescente, array2000Decrescente, array2000Aleatorio);

        Resultado resultadoMerge = testarMergeSort(array20Crescente, array20Decrescente, array20Aleatorio,
                array2000Crescente, array2000Decrescente, array2000Aleatorio);

        Resultado resultadoCounting = testarCountingSort(array20Crescente, array20Decrescente, array20Aleatorio,
                array2000Crescente, array2000Decrescente, array2000Aleatorio);

        // Imprimir resultados
        Resultado.imprimirCabecalho();
        resultadoInsertion.imprimir();
        resultadoMerge.imprimir();
        resultadoCounting.imprimir();
    }

    private static Resultado testarInsertionSort(int[] array20Crescente, int[] array20Decrescente, int[] array20Aleatorio,
                                                 int[] array2000Crescente, int[] array2000Decrescente, int[] array2000Aleatorio) {
        Resultado resultado = new Resultado("Insertion sort");

        double tempo20Crescente = testarAlgoritmo(array20Crescente.clone(), arr -> InsertionSort.ordenar(arr));
        double tempo2000Crescente = testarAlgoritmo(array2000Crescente.clone(), arr -> InsertionSort.ordenar(arr));
        double tempo20Aleatorio = testarAlgoritmo(array20Aleatorio.clone(), arr -> InsertionSort.ordenar(arr));
        double tempo2000Aleatorio = testarAlgoritmo(array2000Aleatorio.clone(), arr -> InsertionSort.ordenar(arr));
        double tempo20Decrescente = testarAlgoritmo(array20Decrescente.clone(), arr -> InsertionSort.ordenar(arr));
        double tempo2000Decrescente = testarAlgoritmo(array2000Decrescente.clone(), arr -> InsertionSort.ordenar(arr));

        resultado.setTempos(tempo20Crescente, tempo2000Crescente, tempo20Aleatorio, tempo2000Aleatorio,
                tempo20Decrescente, tempo2000Decrescente);
        return resultado;
    }

    private static Resultado testarMergeSort(int[] array20Crescente, int[] array20Decrescente, int[] array20Aleatorio,
                                             int[] array2000Crescente, int[] array2000Decrescente, int[] array2000Aleatorio) {
        Resultado resultado = new Resultado("Merge sort");

        double tempo20Crescente = testarAlgoritmo(array20Crescente.clone(), arr -> MergeSort.ordenar(arr));
        double tempo2000Crescente = testarAlgoritmo(array2000Crescente.clone(), arr -> MergeSort.ordenar(arr));
        double tempo20Aleatorio = testarAlgoritmo(array20Aleatorio.clone(), arr -> MergeSort.ordenar(arr));
        double tempo2000Aleatorio = testarAlgoritmo(array2000Aleatorio.clone(), arr -> MergeSort.ordenar(arr));
        double tempo20Decrescente = testarAlgoritmo(array20Decrescente.clone(), arr -> MergeSort.ordenar(arr));
        double tempo2000Decrescente = testarAlgoritmo(array2000Decrescente.clone(), arr -> MergeSort.ordenar(arr));

        resultado.setTempos(tempo20Crescente, tempo2000Crescente, tempo20Aleatorio, tempo2000Aleatorio,
                tempo20Decrescente, tempo2000Decrescente);
        return resultado;
    }

    private static Resultado testarCountingSort(int[] array20Crescente, int[] array20Decrescente, int[] array20Aleatorio,
                                                int[] array2000Crescente, int[] array2000Decrescente, int[] array2000Aleatorio) {
        Resultado resultado = new Resultado("Counting sort");

        double tempo20Crescente = testarAlgoritmo(array20Crescente.clone(), arr -> CountingSort.ordenar(arr));
        double tempo2000Crescente = testarAlgoritmo(array2000Crescente.clone(), arr -> CountingSort.ordenar(arr));
        double tempo20Aleatorio = testarAlgoritmo(array20Aleatorio.clone(), arr -> CountingSort.ordenar(arr));
        double tempo2000Aleatorio = testarAlgoritmo(array2000Aleatorio.clone(), arr -> CountingSort.ordenar(arr));
        double tempo20Decrescente = testarAlgoritmo(array20Decrescente.clone(), arr -> CountingSort.ordenar(arr));
        double tempo2000Decrescente = testarAlgoritmo(array2000Decrescente.clone(), arr -> CountingSort.ordenar(arr));

        resultado.setTempos(tempo20Crescente, tempo2000Crescente, tempo20Aleatorio, tempo2000Aleatorio,
                tempo20Decrescente, tempo2000Decrescente);
        return resultado;
    }

    private static double testarAlgoritmo(int[] array, Consumer<int[]> algoritmo) {
        long tempoTotal = 0;

        for (int i = 0; i < NUM_EXECUCOES; i++) {
            int[] copia = array.clone();
            tempoTotal += Cronometro.medirTempo(() -> algoritmo.accept(copia));
        }

        return tempoTotal / (double) NUM_EXECUCOES;
    }
}