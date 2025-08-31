package questao1.modelo;

public class Resultado {
    private String algoritmo;
    private double tempoMedio20Crescente;
    private double tempoMedio2000Crescente;
    private double tempoMedio20Aleatorio;
    private double tempoMedio2000Aleatorio;
    private double tempoMedio20Decrescente;
    private double tempoMedio2000Decrescente;

    public Resultado(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void setTempos(double tempoMedio20Crescente, double tempoMedio2000Crescente,
                         double tempoMedio20Aleatorio, double tempoMedio2000Aleatorio,
                         double tempoMedio20Decrescente, double tempoMedio2000Decrescente) {
        this.tempoMedio20Crescente = tempoMedio20Crescente;
        this.tempoMedio2000Crescente = tempoMedio2000Crescente;
        this.tempoMedio20Aleatorio = tempoMedio20Aleatorio;
        this.tempoMedio2000Aleatorio = tempoMedio2000Aleatorio;
        this.tempoMedio20Decrescente = tempoMedio20Decrescente;
        this.tempoMedio2000Decrescente = tempoMedio2000Decrescente;
    }

    public void imprimir() {
        System.out.printf("| %-13s | %-15.2f | %-17.2f | %-15.2f | %-17.2f | %-15.2f | %-17.2f |\n",
                algoritmo, tempoMedio20Crescente, tempoMedio2000Crescente,
                tempoMedio20Aleatorio, tempoMedio2000Aleatorio,
                tempoMedio20Decrescente, tempoMedio2000Decrescente);
    }

    public static void imprimirCabecalho() {
        System.out.println("| Algoritmo     | Entrada ordenada     | Entrada ordenada   | Entrada aleatória  | Entrada aleatória    | Entrada inversa             | Entrada inversa  |");
        System.out.println("|               | n=20                 | n=2000             | n=20               | n=2000               | n=20                        | n=2000           |");
        System.out.println("|---------------|----------------------|--------------------|--------------------|----------------------|-----------------------------|------------------|");
    }
}