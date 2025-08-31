package questao1.util;

import java.util.Random;

public class GeradorArray {
    public static int[] gerarArrayCrescente(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] gerarArrayDecrescente(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i - 1;
        }
        return array;
    }

    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(tamanho * 10);
        }
        return array;
    }
}