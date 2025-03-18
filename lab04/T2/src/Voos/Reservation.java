package Voos;


public class Reservation {
    private static int nextSequentialNumber = 1; // Contador estático para gerar números sequenciais únicos para novas reservas

    private final String reservationCode; 
    private int seats;
    private char seatClass;

    public Reservation(String flightCode, int seats, char seatClass) {
        this.seats = seats;
        this.seatClass = seatClass;
        this.reservationCode = flightCode + ":" + nextSequentialNumber++; // Código de reserva no formato "flightCode:sequentialNumber"
    }

    // Métodos getters
    public String getReservationCode() {
        return reservationCode;
    }

    public int getSeats() {
        return seats;
    }

    public char getSeatClass() {
        return seatClass;
    }

    // Método para redefinir o contador sequencial
    public static void resetSequentialNumber(int start) {
        nextSequentialNumber = start;
    }
}
