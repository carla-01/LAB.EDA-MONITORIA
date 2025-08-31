package questao1.util;

public class Cronometro {
    public static long medirTempo(Runnable funcao) {
        long inicio = System.nanoTime();
        funcao.run();
        long fim = System.nanoTime();
        return fim - inicio;
    }
}