package questao1.algoritmos;

public class InsertionSort {
    public static void ordenar(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];  // ← "chave" mudou para "key"
            int j = i - 1;

            while (j >= 0 && array[j] > key) {  // ← "key" aqui também
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;  // ← e aqui
        }
    }
}