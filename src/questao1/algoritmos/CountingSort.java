package questao1.algoritmos;

public class CountingSort {
    public static void ordenar(int[] array) {
        int maximo = encontrarMaximo(array);
        int minimo = encontrarMinimo(array);
        int intervalo = maximo - minimo + 1;

        int[] contador = new int[intervalo];
        int[] resultado = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            contador[array[i] - minimo]++;
        }

        for (int i = 1; i < contador.length; i++) {
            contador[i] += contador[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            resultado[contador[array[i] - minimo] - 1] = array[i];
            contador[array[i] - minimo]--;
        }

        System.arraycopy(resultado, 0, array, 0, array.length);
    }

    private static int encontrarMaximo(int[] array) {
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    private static int encontrarMinimo(int[] array) {
        int minimo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        return minimo;
    }
}