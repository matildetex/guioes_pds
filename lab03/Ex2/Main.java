import java.util.Scanner;
import java.io.File;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            processCommandsFromFile(args[0]);
        } else {
            processCommandsFromUserInput();
        }
    }

    private static void processCommandsFromUserInput() {
        while (true) {
            displayMenu();
            String value = sc.nextLine();
            if (value.toUpperCase().startsWith("Q")) {
                sc.close();
                System.exit(0);
            }
            processCommand(value);
        }
    }

    private static void processCommandsFromFile(String filename) throws Exception {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String value = fileScanner.nextLine();
            processCommand(value);
            if (value.toUpperCase().startsWith("Q")) {
                break;
            }
        }

        fileScanner.close();
    }
    
    private static void processCommand(String value) {
        if (value.toUpperCase().startsWith("H")) {
            System.out.println("\nOpções:\n- I filename : Lê Ficheiro com Informação de Voo\n- M flight_code : Mostra Mapa de Reservas do Voo Inserido\n- F flight_code num_seats_executive num_seats_tourist : Acrescenta Novo Voo \n- R flight_code class number_seats: Acrescenta Nova Reserva de Voo\n- C reservation_code : Cancela Reserva\n- Q : Termina Programa\n");
        } else if (value.toUpperCase().startsWith("I")) {
            String[] params = value.split(" ");
            if (params.length != 2) {
                System.out.println("\nInput inválido. Ex: I filename");
            } else {
                optionI(params[1]);
            }
        } else if (value.toUpperCase().startsWith("M")) {
            String[] params = value.split(" ");
            if (params.length != 2) {
                System.out.println("\nInput inválido. Ex: M flightcode");
            } else {
                optionM(params[1]);
            }
        } else if (value.toUpperCase().startsWith("F")) {
            String[] params = value.split(" ");
            if (params.length == 4 || params.length == 3) {
                if(params.length==3){
                    optionF(params[1],"0", params[2]);
                }
                else{
                    optionF(params[1], params[2], params[3]);
                }
            } else {
                System.out.println("\nInput inválido. Ex: F flight_code num_seats_executive num_seats_tourist");
            }
        } else if (value.toUpperCase().startsWith("R")) {
            String[] valores = value.split("\\s+");
            if (valores.length != 4) {
                System.out.println("\nInput inválido. Ex: R flight_code class number_seats");
            } else {
                optionR(valores[1], valores[2], valores[3]);
            }
        } else if (value.toUpperCase().startsWith("C")) {
            String[] valores = value.split("\\s+");
            if (valores.length != 2) {
                System.out.println("\nInput inválido. Ex: C reservation_code");
            } else {
                optionC(valores[1]);
            }
        }
    }

    private static void optionC(String reservation_code) {
        Reservation.cancel(reservation_code);
    }

    private static void optionR(String flightcode, String classe, String num_seats_str) {
        int num_seats=Integer.parseInt(num_seats_str);
        Reservation.makeReservation(flightcode, classe, num_seats);
    }

    private static void optionF(String flightcode, String num_seats_executive_str, String num_seats_tourist_str) {
        String[] num_seats_tourist_array=num_seats_tourist_str.split("x");
        if(num_seats_executive_str!="0"){
            String[] num_seats_executive_array=num_seats_executive_str.split("x");
            FlightManager.addnewFlightBothClasses(flightcode,
            Integer.parseInt(num_seats_executive_array[0]),
            Integer.parseInt(num_seats_executive_array[1]),
            Integer.parseInt(num_seats_tourist_array[0]),
            Integer.parseInt(num_seats_tourist_array[1]));
        }else{
            FlightManager.addnewFlightTourist(flightcode, Integer.parseInt(num_seats_tourist_array[0]), Integer.parseInt(num_seats_tourist_array[1]));
        }
    }

    private static void optionM(String substring) {
        Reservation.showLugares(substring);
    }

    private static void optionI(String substring) {
        FileReader.readFile(substring);
    }

    private static void displayMenu() {
        System.out.println("\nEscolha uma opção: (H para ajudar)");
    }
}
