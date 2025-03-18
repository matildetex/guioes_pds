import java.util.ArrayList;
import java.util.List;

public class ReservationMaker {
    public static boolean ticketsLeft=true;
    public static int reservaid = 1;
    public static List<String> lugaresReservadosPrint=new ArrayList<String>();

    public static boolean realizarReservas(int[][] reservasExecutiva, int[][] reservasTuristica, int numeroBilhetes, char classeDesejada) {
        if (classeDesejada == 'E' || classeDesejada == 'e') {
            ticketsLeft= verificarDisponibilidade(reservasExecutiva, numeroBilhetes);
        } else if (classeDesejada == 'T' || classeDesejada == 't') {
            ticketsLeft= verificarDisponibilidade(reservasTuristica, numeroBilhetes);
        } else {
            System.out.println("\nClasse inválida. Tente novamente.");
        }
        return ticketsLeft;
    }


    public static void exibirAssentos(int[][] reservasExecutiva, int colunasExecutiva, int num_filas_exec, int[][] reservasTuristica, int colunasTuristica, int num_filas_tur) {
        int max_filas = Math.max(num_filas_exec, num_filas_tur);
        int lastExecCol = colunasExecutiva;  
        System.out.println("\n");  
        // Reservas executivas
        System.out.print("  ");
        for (int i = 0; i < colunasExecutiva; i++) {
            System.out.print(String.format("%-4s", i + 1)); 
        }

        if (num_filas_exec > 0) {
            System.out.print("|| ");
        }
        // Reservas turísticas
        int turisticaStartCol = lastExecCol + 1;
        for (int i = turisticaStartCol; i < turisticaStartCol + colunasTuristica; i++) {
            System.out.print(String.format("%-4s", i)); 
        }
        System.out.println();

        for (int i = 0; i < max_filas; i++) {
            char letter = (char) ('A' + i);
            System.out.print(letter + " ");
            if (i < num_filas_exec) {
                for (int j = 0; j < colunasExecutiva; j++) {
                    if (j < reservasExecutiva[i].length) {
                        System.out.print(String.format("%-4s", reservasExecutiva[i][j])); 
                    } else {
                        System.out.print("    "); 
                    }
                }
            System.out.print("|| ");
            } else {
                for (int j = 0; j < colunasExecutiva; j++) {
                    System.out.print("    ");
                }
                if (num_filas_exec > 0) {
                    System.out.print("|| ");
                }
            }

            if (i < num_filas_tur) {
                for (int j = 0; j < colunasTuristica; j++) {
                    if (j < reservasTuristica[i].length) {
                        System.out.print(String.format("%-4s", reservasTuristica[i][j])); 
                    } else {
                        System.out.print("    "); 
                    }
                }
            } else {
                for (int j = 0; j < colunasTuristica; j++) {
                    System.out.print("    "); 
                }
            }
            System.out.println();
        }
    }



    public static void adicionarBilhetes(int[][] reservas, int numeroBilhetes) {
        int filas = reservas.length;
        int colunas = reservas[0].length;
        int bilhetesAdicionados = 0;
        
        for (int j = 0; j < colunas && bilhetesAdicionados < numeroBilhetes; j++) {
            for (int i = 0; i < filas && bilhetesAdicionados < numeroBilhetes; i++) {
                if (reservas[i][j] == 0) {
                    reservas[i][j] = reservaid;
                    String lugar = (i + 1) + "" + (char)('A' + j);
                    lugaresReservadosPrint.add(lugar);
                    bilhetesAdicionados++;
                }
            }
        }
        reservaid++;

        if (bilhetesAdicionados == 0) {
            System.out.println("\nNão há lugares disponíveis para adicionar bilhetes.");
        } else {
            System.out.println("\n" + bilhetesAdicionados + " bilhetes adicionados com sucesso!");
        }
    }

    public static boolean verificarDisponibilidade(int[][] reservas, int numeroBilhetes) {
        if(reservas==null){
            System.out.println("\nNão há essa classe neste voo");
            return false;
        }
        int filas = reservas.length;
        int colunas = reservas[0].length;
        boolean ticketsLeft=true;
        int assentosDisponiveis = 0;
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (reservas[i][j] == 0) {
                    assentosDisponiveis++;
                }
            }
        }
        if (assentosDisponiveis >= numeroBilhetes) {
            adicionarBilhetes(reservas, numeroBilhetes);
        } else {
            ticketsLeft=false;
            System.out.println("\nNão há bilhetes para esta classe. Escolha outra.");
        }
        return ticketsLeft;
    }
    

    public static boolean cancelarBilhete(int[][] reservas, int bilhete) {
        boolean bilheteEncontrado = false;
        int filas = reservas.length;
        int colunas = reservas[0].length;
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (reservas[i][j] == bilhete) {
                    reservas[i][j] = 0;
                    bilheteEncontrado = true;
                }
            }
        }
        return bilheteEncontrado;
    }

    
    
    

}
