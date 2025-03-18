import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    public static Plane newFlight;
    private static List<Plane> flights = new ArrayList<>();

    public static void addnewFlightBothClasses(String flightCode,int num_col_exec, int num_filas_exec, int num_filas_tur, int num_col_tur) {
        if(flightExists(flightCode)){
            System.out.println("\nVoo já existe.");
            return;
        }
        newFlight = new Plane(flightCode, ClassPlane.EXECUTIVA, num_col_exec, num_filas_exec, num_filas_tur, num_col_tur);
        flights.add(newFlight);
        System.out.println("\nNovo Voo Adicionado: " + newFlight);
    }

    public static void addnewFlightTourist(String flightCode, int num_filas_tur, int num_col_tur) {
        if(flightExists(flightCode)){
            System.out.println("\nVoo já existe.");
            return;
        }
        newFlight = new Plane(flightCode, ClassPlane.TURISTICA, 0, 0, num_filas_tur, num_col_tur);
        flights.add(newFlight);
        System.out.println("\nNovo Voo Adicionado: " + newFlight);
    }

    public static List<Plane> getFlights() {
        return flights;
    }

    public static boolean flightExists(String code) {
        Plane plane = Reservation.getVoo(code);
        return plane != null;
    }
    
}