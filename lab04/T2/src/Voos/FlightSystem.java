package Voos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FlightSystem {
    private static HashMap<String, Flight> flights = new HashMap<>();

    public static void main(String args[]){

        if (args.length == 0) {                 
            menu();                 // Quando não tem o arg com o ficheiro de comandos

        } else if (args.length == 1) {          
                                    // Quando tem o arg com o ficheiro de comandos
            try {
                File fl = new File(args[0]);
                Scanner sc = new Scanner(fl);
    
                while (sc.hasNextLine()) {
                    String option[] = sc.nextLine().split(" ");
                    menuOptions(option);
                }
    
                sc.close();
    
            } catch (FileNotFoundException e) {
                System.out.println("Ficheiro não existente, tenta outra vez.");
            }

        } else {
            System.out.println("Número inválido de argumentos.");
        }

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
    
        while (true) { // Loop infinito controlado pela função menuOptions
            System.out.println("Escolha uma opção (H para ajuda): ");
            String[] option = sc.nextLine().split(" ");
            boolean continueRunning = menuOptions(option);
            if (!continueRunning) {
                break; // Sai do loop se menuOptions retornar false
            }
        }
    
        sc.close();
    }
    

    public static boolean menuOptions(String[] option){
        do {
            switch (option[0].toUpperCase().charAt(0)) {
                case 'H':
                    System.out.println("Menu de Ajuda:");
                    System.out.println("- H: Exibe as opções do menu.");
                    System.out.println("- I <arquivo>: Carrega informações de voo de um arquivo.");
                    System.out.println("- M <código_voo>: Mostra mapa de assentos do voo.");
                    System.out.println("- F <código_voo> <lugares_executiva> <lugares_turística>: Adiciona um novo voo.");
                    System.out.println("- R <código_voo> <classe> <nº_assentos>: Faz uma reserva.");
                    System.out.println("- C <código_reserva>: Cancela uma reserva.");
                    System.out.println("- Q: Encerra o programa.");
                    return true;

                case 'I':
                    if (option.length != 2) {
                        System.err.println("Erro: Número de argumentos inválido.");
                        break;
                    }
                
                    try {
                        File file = new File(option[1]);
                        Scanner reader = new Scanner(file);
                
                        Flight flight = null;
                
                        if (reader.hasNextLine()) {
                            String line = reader.nextLine().trim(); // Primeira linha com informações do voo e do avião
                            if (!line.startsWith(">")) {
                                System.err.println("Formato de arquivo inválido. Esperado '>' no início do código do voo.");
                                reader.close();
                                break;
                            }
                
                            String[] flightInfo = line.substring(1).split(" ");
                            if (!validFlightCode(flightInfo[0])) {
                                System.err.println("Erro: Formato de código de voo inválido.");
                                reader.close();
                                break;
                            }
                
                            String flightCode = flightInfo[0];
                            Plane plane;
                            // Verificar se existe classe executiva
                            if (flightInfo.length == 3) {
                                String[] execConfig = flightInfo[1].split("x");
                                int execRows = Integer.parseInt(execConfig[0]);
                                int execSeatsPerRow = Integer.parseInt(execConfig[1]);
                                String[] turConfig = flightInfo[2].split("x");
                                int turRows = Integer.parseInt(turConfig[0]);
                                int turSeatsPerRow = Integer.parseInt(turConfig[1]);
                                plane = new Plane(turRows, turSeatsPerRow, execRows, execSeatsPerRow); // Classe executiva e turística
                            } else {
                                String[] turConfig = flightInfo[1].split("x");
                                int turRows = Integer.parseInt(turConfig[0]);
                                int turSeatsPerRow = Integer.parseInt(turConfig[1]);
                                plane = new Plane(turRows, turSeatsPerRow); // Apenas classe turística
                            }
                
                            flight = new Flight(flightCode, plane);
                            flights.put(flightCode, flight); // Adiciona o voo ao sistema
                        }
                
                        // Processa as reservas subsequentes
                        while (reader.hasNextLine()) {
                            String line = reader.nextLine().trim();
                            String[] reservationInfo = line.split(" ");
                            char seatClass = reservationInfo[0].charAt(0); // E ou T
                            int numSeats = Integer.parseInt(reservationInfo[1]);
                
                            // Verifica se o voo foi criado corretamente antes de tentar adicionar reservas
                            if (flight != null) {
                                flight.addReservation(new Reservation(flight.getFlightCode(), numSeats, seatClass));
                            }
                        }
                
                        reader.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("Erro: Arquivo não encontrado.");
                    }
                    return true;
                

                case 'M':
                    if (option.length != 2) {
                        System.err.println("Erro: Número de argumentos inválido.");
                    } else {
                        String flightCode = option[1];
                        if (validFlightCode(flightCode)) {
                            Flight flightToShow = flights.get(flightCode);
                            if (flightToShow != null) {
                                flightToShow.showSeatMap();
                            } else {
                                System.out.println("Erro: Voo não encontrado.");
                            }
                        } else {
                            System.err.println("Erro: Formato de código de voo inválido.");
                        }
                    }
                    return true;
                
                    case 'F':
                        // Checa se os argumentos são para voo com ou sem classe executiva
                        if (option.length == 4 || option.length == 3) {
                            String flightCode = option[1];

                            // Verifica se o formato do código do voo é válido
                            if (!validFlightCode(flightCode)) {
                                System.err.println("Erro: Formato de código de voo inválido.");
                                break;
                            }

                            try {
                                Plane plane;
                                // Caso com classe executiva
                                if (option.length == 4) {
                                    String[] execSeatsConfig = option[2].split("x");
                                    int filasExec = Integer.parseInt(execSeatsConfig[0]);
                                    int lugPorFilaExec = Integer.parseInt(execSeatsConfig[1]);

                                    String[] turSeatsConfig = option[3].split("x");
                                    int filasTur = Integer.parseInt(turSeatsConfig[0]);
                                    int lugPorFilaTur = Integer.parseInt(turSeatsConfig[1]);

                                    plane = new Plane(filasTur, lugPorFilaTur, filasExec, lugPorFilaExec);
                                } else {
                                    // Caso sem classe executiva
                                    String[] turSeatsConfig = option[2].split("x");
                                    int filasTur = Integer.parseInt(turSeatsConfig[0]);
                                    int lugPorFilaTur = Integer.parseInt(turSeatsConfig[1]);

                                    plane = new Plane(filasTur, lugPorFilaTur);
                                }

                                // Adiciona o novo voo ao sistema
                                Flight newFlight = new Flight(flightCode, plane);
                                flights.put(flightCode, newFlight);
                                System.out.println("Voo adicionado com sucesso: " + flightCode);

                            } catch (NumberFormatException e) {
                                System.err.println("Erro: Formato numérico inválido nos argumentos.");
                            }

                        } else {
                            System.err.println("Erro: Número de argumentos inválido para adicionar um voo.");
                        }
                        return true;

                    case 'R':
                        if (option.length != 4) {
                            System.err.println("Erro: Número de argumentos inválido.");
                        } else {
                            String flightCode = option[1];
                            char seatClass = option[2].charAt(0); 
                            int numSeats;
                    
                            try {
                                numSeats = Integer.parseInt(option[3]);
                            } catch (NumberFormatException e) {
                                System.err.println("Erro: O número de assentos deve ser um inteiro válido.");
                                break;
                            }
                    
                            if (!validFlightCode(flightCode)) {
                                System.err.println("Erro: Formato de código de voo inválido.");
                                break;
                            }
                    
                            Flight flight = flights.get(flightCode);
                            if (flight == null) {
                                System.out.println("Erro: Voo não encontrado.");
                                break;
                            }
                    
                            // Instancia uma nova reserva e tenta adicioná-la ao voo
                            Reservation reservation = new Reservation(flightCode, numSeats, seatClass);
                            if (flight.addReservation(reservation)) {
                                System.out.println("Reserva adicionada com sucesso. Código da reserva: " + reservation.getReservationCode());
                            } 
                        }
                        return true;
                    
                        case 'C':
                        if (option.length != 2) {
                            System.err.println("Erro: Número de argumentos inválido.");
                        } else {
                            String reservationCode = option[1];
                            String[] parts = reservationCode.split(":");
                            if (parts.length != 2) {
                                System.err.println("Erro: Formato de código de reserva inválido.");
                                break;
                            }
                            String flightCode = parts[0];
                            
                            Flight flight = flights.get(flightCode);
                            if (flight == null) {
                                System.err.println("Erro: Voo não encontrado.");
                                break;
                            }
                            
                            // Tenta cancelar a reserva
                            boolean reservationCancelled = flight.cancelReservation(reservationCode);
                            if (reservationCancelled) {
                                System.out.println("Reserva cancelada com sucesso: " + reservationCode);
                            } else {
                                System.out.println("Erro ao cancelar a reserva. Pode não existir ou já foi cancelada.");
                            }
                        }
                        return true;
                    
                    
                    case 'Q':
                        System.out.println("Programa encerrado.");
                        return false;
                    default:
                        System.out.println("Opção inválida. Digite 'H' para ajuda.");
                        return true;
            }
        } while (option[0].charAt(0) != 'Q');
        return true;
    }

    public static boolean validFlightCode(String flightCode) {
        String pattern = "^[A-Z]{2}\\d{4}$";
        return flightCode.matches(pattern);
    }

    public static boolean verifyHasExecutiveSeats(String[] firstLine){
        if (firstLine.length == 3){
            return true;
        }
        else{
            return false;
        }
    }
}
