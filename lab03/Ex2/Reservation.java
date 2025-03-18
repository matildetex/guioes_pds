import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {

    public static String vooId;
    private static Plane plane;
    public static Map<String, Integer> reservations = new HashMap<>();
    public static int numBilhetes;

    public Reservation(String vooId, Plane plane, Map<String, Integer> reservations, int numBilhetes) {
        this.vooId = vooId;
        this.plane = plane;
        this.reservations = reservations;
        this.numBilhetes = numBilhetes;
    }

    public String getVooId() {
        return vooId;
    }

    public int getNumBilhetes() {
        return numBilhetes;
    }

    public void setNumBilhetes(int numBilhetes) {
        this.numBilhetes = numBilhetes;
    }

    public void setVooId(String vooId) {
        this.vooId = vooId;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Map<String, Integer> getReservations() {
        return reservations;
    }

    public void setReservations(Map<String, Integer> reservations) {
        this.reservations = reservations;
    }

    public static void cancel(String reservation_code) {
        boolean findArrayExec=false;
        String[] parameters=reservation_code.split(":"); 
        Plane plane=getVoo(parameters[0]);
        if (plane==null){
            System.out.println("Voo não encontrado");
            return;
        }
        int numBilhetes=Integer.parseInt(parameters[1]);
        int[][] reservas_exec=plane.getReservasExecutiva();
        int[][] reservasTur=plane.getReservasTuristica();
        boolean findArrayTur=ReservationMaker.cancelarBilhete(reservasTur, numBilhetes);
        if(reservas_exec!=null) {            
            findArrayExec= ReservationMaker.cancelarBilhete(reservas_exec,  numBilhetes);
        }
        if(findArrayTur==true || findArrayExec==true) {
            System.out.println("Reserva " + reservation_code + " cancelada com sucesso.");
        }
        else{
            System.out.println("Reserva " + reservation_code + "não encontrada");
        }
    }

    public static void makeReservation(String flightcode, String classe, int num_seats) {
        char classechar=classe.charAt(0);
        Plane plane=getVoo(flightcode);
        if (plane==null){
            System.out.println("Voo não encontrado");
            return;
        }
        int[][] reservasExecutiva =plane.getReservasExecutiva();
        int[][] reservasTuristica =plane.getReservasTuristica();
        boolean ticketsLeft= ReservationMaker.realizarReservas(reservasExecutiva, reservasTuristica, num_seats, classechar);
        int id=ReservationMaker.reservaid-1;
        if(ticketsLeft){
            if (!ReservationMaker.lugaresReservadosPrint.isEmpty()) {
                System.out.print(flightcode + ":" + id + " = ");
                for (int i = 0; i < ReservationMaker.lugaresReservadosPrint.size(); i++) {
                    System.out.print(ReservationMaker.lugaresReservadosPrint.get(i));
                    if (i < ReservationMaker.lugaresReservadosPrint.size() - 1) {
                        System.out.print(" | ");
                    }
                }
            }
        }
        System.out.println("\n");
    }

    public static void showLugares(String flightcode){
        Plane plane=getVoo(flightcode);
        if (plane==null){
            System.out.println("Voo não encontrado");
            return;
        }
        int filasExecutiva= plane.getNum_filas_exec();
        int colunasExecutiva= plane.getNum_col_exec();
        int filasTuristica=plane.getNum_filas_tur();
        int colunasTuristica=plane.getNum_col_tur();
        int[][] reservasTuristica = plane.getReservasTuristica();
        int[][] reservasExecutiva = plane.getReservasExecutiva();
        ReservationMaker.exibirAssentos(reservasExecutiva, colunasExecutiva, filasExecutiva, reservasTuristica, colunasTuristica, filasTuristica);
    }

    public static Plane getVoo(String code){
        List<Plane> listaVoos= FlightManager.getFlights();
        for(Plane plane : listaVoos){
            if(plane.getFlightCode().equals(code)){
                return plane;
            }
        }
        return null;
    }


}