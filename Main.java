import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] numbers = gerarNumerosAleatorios(1000, -9999, 9999);

        ListaDuplamenteEncadeada list = new ListaDuplamenteEncadeada();
        for (int number : numbers) {
            list.inserir(number);
        }

        System.out.println("Lista em ordem crescente:");
        list.imprimirOrdemCrescente();

        System.out.println("Lista em ordem decrescente:");
        list.imprimirOrdemDecrescente();

        System.out.println("Removendo números primos...");
        list.removerPrimos();

        System.out.println("Lista após remoção de números primos em ordem crescente:");
        list.imprimirOrdemCrescente();

        System.out.println("Lista após remoção de números primos em ordem decrescente:");
        list.imprimirOrdemDecrescente();
    }
    private static int[] gerarNumerosAleatorios(int quantidade, int min, int max) {
        Random random = new Random();
        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            numeros[i] = random.nextInt(max - min + 1) + min;
        }

        return numeros;
    }
}
  