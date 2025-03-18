package lab12.Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro("Java Anti-Stress", "12345", 2020, "Omodionah"));
        livros.add(new Livro("A Guerra dos Padrões", "67890", 2021, "Jorge Omel"));
        livros.add(new Livro("A Procura da Luz", "11223", 2022, "Khumatkli"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*** Biblioteca ***");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println((i + 1) + " " + livros.get(i).toString());
            }
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela>");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] parts = input.split(",");
            int livroIndex = Integer.parseInt(parts[0]) - 1;
            int operacao = Integer.parseInt(parts[1]);

            Livro livro = livros.get(livroIndex);
            switch (operacao) {
                case 1:
                    livro.regista();
                    break;
                case 2:
                    livro.requisita();
                    break;
                case 3:
                    livro.devolve();
                    break;
                case 4:
                    livro.reserva();
                    break;
                case 5:
                    livro.cancelaReserva();
                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        }
        scanner.close();
    }
}
