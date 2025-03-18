import java.util.ListIterator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Criar um vetor genérico de inteiros
        VectorGeneric<Integer> vetor = new VectorGeneric<>();

        // Adicionar elementos ao vetor
        vetor.addElem(1);
        vetor.addElem(2);
        vetor.addElem(3);

        // Iterar sobre os elementos usand um Iterator
        System.out.println("Iterando usando Iterator:");
        for (Iterator<Integer> it = vetor.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        // Obter um ListIterator e iterando sobre os elementos
        System.out.println("\nIterando usando ListIterator:");
        ListIterator<Integer> listIterator = vetor.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // Remover um elemento do vetor
        System.out.println("\nRemovendo o elemento 2:");
        vetor.removeElem(2);

        // Imprimir o número total de elementos após a remoção
        System.out.println("Número total de elementos após a remoção: " + vetor.totalElem());
    }
}
