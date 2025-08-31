package questao2;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(7);

        System.out.println("=== INSERÇÃO ===");
        tabela.inserir(10);
        tabela.inserir(20);
        tabela.inserir(15);
        tabela.inserir(7);
        tabela.inserir(14);
        tabela.inserir(21);
        tabela.inserir(10);

        tabela.print();

        System.out.println("\n=== BUSCA ===");
        System.out.println("Buscar 15: " + tabela.buscar(15));
        System.out.println("Buscar 99: " + tabela.buscar(99));

        System.out.println("\n=== REMOÇÃO ===");
        System.out.println("Remover 14: " + tabela.remover(14));
        System.out.println("Remover 99: " + tabela.remover(99));

        tabela.print();
    }
}