import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void readFile(String substring) {
        int lugaresDisponiveisExecutiva = 0;
        int lugaresDisponiveisTuristica = 0;
        try {
            File arquivo = new File("Files/" + substring.trim());
            Scanner scanner = new Scanner(arquivo);

            if (scanner.hasNextLine()) {
                String primeiraLinha = scanner.nextLine();

                if (primeiraLinha.startsWith(">")) {
                    String[] informacoesVoo = primeiraLinha.substring(1).split("\\s+");

                    // Extrai Informações Voo
                    String codigoVoo = informacoesVoo[0];
                    int filasExecutiva = 0;
                    int lugaresPorFilaExecutiva = 0;
                    int filasTuristica= 0;
                    int lugaresPorFilaTuristica = 0;

                    try {
                        if(informacoesVoo.length ==2) {
                            String[] turInfo = informacoesVoo[1].split("x");
                            filasTuristica = Integer.parseInt(turInfo[0]);
                            lugaresPorFilaTuristica = Integer.parseInt(turInfo[1]);
                        }else{ 
                                String[] execInfo = informacoesVoo[1].split("x");
                                filasExecutiva = Integer.parseInt(execInfo[0]);
                                lugaresPorFilaExecutiva = Integer.parseInt(execInfo[1]);
                                String[] turInfo = informacoesVoo[2].split("x");
                                filasTuristica = Integer.parseInt(turInfo[0]);
                                lugaresPorFilaTuristica = Integer.parseInt(turInfo[1]);
                           
                            // Calcula lugares disponíveis executiva, quando existe
                            lugaresDisponiveisExecutiva = filasExecutiva * lugaresPorFilaExecutiva;
                        }
                        // Calcula lugares disponíveis turistica sempre
                        lugaresDisponiveisTuristica = filasTuristica * lugaresPorFilaTuristica;
                        // Imprime as informações do voo
                        if (lugaresDisponiveisExecutiva == 0) {
                            System.out.println("\nCódigo de Voo: " + codigoVoo + ". Lugares disponíveis: " + lugaresDisponiveisTuristica + " lugares em classe Turística.");
                            System.out.println("Classe executiva não disponível neste voo.");
                        } else {
                            System.out.println("\nCódigo de Voo: " + codigoVoo + ". Lugares disponíveis: " + lugaresDisponiveisExecutiva + " lugares em classe Executiva; " + lugaresDisponiveisTuristica + " lugares em classe Turística.");
                        }

                    } catch (NumberFormatException ex) {
                        System.out.println("\nErro ao converter uma string para número na leitura das informações de voo: " + ex.getMessage());
                    }

                    // Verifica reservas
                    while (scanner.hasNextLine()) {
                        String linhaReserva = scanner.nextLine();
                        try {
                            if (linhaReserva.startsWith("T")) {
                                lugaresDisponiveisTuristica -= Integer.parseInt(linhaReserva.substring(2));
                            }
                            if (linhaReserva.startsWith("E")) {
                                lugaresDisponiveisExecutiva -= Integer.parseInt(linhaReserva.substring(2));
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("\nErro ao converter uma string para número na leitura das reservas: " + ex.getMessage());
                        }

                        if (lugaresDisponiveisTuristica < 0 || lugaresDisponiveisExecutiva < 0) {
                            System.out.println("Não foi possível obter lugares para a reserva: " + linhaReserva);
                            break;
                        }
                    }
                } else {
                    System.out.println("\nO arquivo não está formatado corretamente. A primeira linha deve começar com '>'.");
                }

                scanner.close();
            } else {
                System.out.println("\nO arquivo está vazio.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nArquivo não encontrado: " + e.getMessage());
        }
    }
}
