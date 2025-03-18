package Voos;

import java.util.HashMap;

public class Flight {
    private String flightCode;
    private Plane plane;
    private HashMap<String, Reservation> reservations;
    private boolean hasExecutiveClass;
    private int[][] seatsTouristic;
    private int[][] seatsExecutive;

    // Construtor
    public Flight(String flightCode, Plane plane) {
        this.flightCode = flightCode;
        this.plane = plane;
        this.reservations = new HashMap<>();
        this.initializeSeats();
    }

    

    // Inicializa as matrizes de assentos com base na configuração do avião
    private void initializeSeats() {
        // Verifica se o avião tem classe executiva
        if (plane.getExecutiveRows() > 0) {
            hasExecutiveClass = true;
            seatsExecutive = new int[plane.getExecutiveRows()][plane.getSeatsPerRowOnExecutive()];
            for (int i = 0; i < seatsExecutive.length; i++) {
                for (int j = 0; j < seatsExecutive[i].length; j++) {
                    seatsExecutive[i][j] = 0; // 0 indica que o assento está disponível
                }
            }
        }
    
        // Inicializa os assentos turísticos
        seatsTouristic = new int[plane.getTouristRows()][plane.getSeatsPerRowOnTourist()];
        for (int i = 0; i < seatsTouristic.length; i++) {
            for (int j = 0; j < seatsTouristic[i].length; j++) {
                seatsTouristic[i][j] = 0; // 0 indica que o assento está disponível
            }
        }
    }
    

    // Métodos para gestão de reservas

    public boolean addReservation(Reservation reservation) {
        boolean isAvailable = checkSeatsAvailability(reservation.getSeatClass(), reservation.getSeats());
        
    
        if (!isAvailable) {
            System.out.println("Não há assentos disponíveis suficientes para a reserva: " + reservation.getSeatClass() + " " + reservation.getSeats());

            return false;
        }
    
        String[] parts = reservation.getReservationCode().split(":");
        int reservationNumber = Integer.parseInt(parts[1]);
        allocateSeats(reservation.getSeatClass(), reservation.getSeats(), reservationNumber);
        reservations.put(reservation.getReservationCode(), reservation);
        return true;
    }
    

    private boolean checkSeatsAvailability(char seatClass, int seatsRequested) {
        int[][] seats = (seatClass == 'E') ? seatsExecutive : seatsTouristic;
        int seatsAvailable = 0;
    
        // Conta quantos assentos estão disponíveis (marcados com 0)
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    seatsAvailable++;
                }
            }
        }
    
        // Verifica se o número de assentos disponíveis é suficiente
        return seatsAvailable >= seatsRequested;
    }
    

    
    private void allocateSeats(char seatClass, int seatsRequested, int reservationNumber) {
        int[][] seats = (seatClass == 'E') ? seatsExecutive : seatsTouristic;
        int seatsAllocated = 0;
    
        // Alocar assentos sequencialmente, marcando-os com o número da reserva
        for (int i = 0; i < seats.length && seatsAllocated < seatsRequested; i++) {
            for (int j = 0; j < seats[i].length && seatsAllocated < seatsRequested; j++) {
                if (seats[i][j] == 0) { // 0 indica assento disponível
                    seats[i][j] = reservationNumber; // Marcar assento com o número da reserva
                    seatsAllocated++;
                }
            }
        }
    }
    
    


    public boolean cancelReservation(String reservationCode) {
        Reservation reservation = reservations.remove(reservationCode);
        if (reservation == null) {
            return false; // Reserva não encontrada
        }
        
        
        releaseSeats(reservationCode);
        return true;
    }
    
    
    
    
    private void releaseSeats(String reservationCode) {
        // Extrai o número sequencial da reserva a partir do reservationCode
        String[] parts = reservationCode.split(":");
        int reservationNumber = Integer.parseInt(parts[1]);
    
        // Disponibiliza os assentos marcados com o número da reserva
        for (int[][] seats : new int[][][]{seatsExecutive, seatsTouristic}) {
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (seats[i][j] == reservationNumber) { // Se o assento está marcado com o número da reserva
                        seats[i][j] = 0; // Assento agora está disponível
                    }
                }
            }
        }
    }
    
    
    
    

    // Exibe o mapa de assentos do voo

    public void showSeatMap() {
        int totalRows = seatsExecutive.length + seatsTouristic.length; 
        int maxSeatsPerRow = Math.max(seatsExecutive[0].length, seatsTouristic[0].length); // Encontra o número máximo de assentos por fila
    
        // Imprime o cabeçalho com os números das colunas
        System.out.print("  "); // Espaçamento para as letras das filas
        for (int seatNum = 1; seatNum <= maxSeatsPerRow; seatNum++) {
            System.out.printf("%3d", seatNum);
        }
        System.out.println();
    
        // Itera sobre cada fila
        for (int row = 0; row < totalRows; row++) {
            System.out.printf("%c ", 'A' + row); // Imprime a letra da fila
    
            // Determina qual matriz de assentos usar (executiva ou turística) e o índice da fila nessa matriz
            int[][] currentSeats = row < seatsExecutive.length ? seatsExecutive : seatsTouristic;
            int rowIndexInCurrentSeats = row < seatsExecutive.length ? row : row - seatsExecutive.length;
    
            // Imprime o estado de cada assento na fila
            for (int seat = 0; seat < maxSeatsPerRow; seat++) {
                if (seat < currentSeats[rowIndexInCurrentSeats].length) {
                    System.out.printf("%3d", currentSeats[rowIndexInCurrentSeats][seat]);
                } else {
                    System.out.print("   "); // Espaços em branco para filas com menos assentos que o máximo
                }
            }
            System.out.println();
        }
    }
    
    
    public int availableSeats(char seatClass) {
        int available = 0;
        int[][] seats;
        
        // Escolhe a matriz de assentos baseada na classe fornecida
        if (seatClass == 'E' && hasExecutiveClass) {
            seats = seatsExecutive;
        } else {
            seats = seatsTouristic;
        }
        
        // Conta os assentos disponíveis
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) { // 0 indica um assento disponível
                    available++;
                }
            }
        }
        
        return available;
    }
    

    
    public String getFlightCode() {
        return flightCode;
    }


}

