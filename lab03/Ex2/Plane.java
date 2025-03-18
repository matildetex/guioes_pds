
public class Plane {
    private String flightCode;
    private ClassPlane plane;
    private int num_filas_exec;
    private int num_col_exec;
    private int num_filas_tur;
    private int num_col_tur;
    public int[][] reservasExecutiva;
    public int[][] reservasTuristica;
    
    public Plane(String flightCode, ClassPlane plane, int num_col_exec, int num_filas_exec, int num_filas_tur, int num_col_tur) {
        this.flightCode = flightCode;
        this.plane = plane;
        this.num_filas_exec=num_filas_exec;
        this.num_col_exec=num_col_exec;
        this.num_filas_tur=num_filas_tur;
        this.num_col_tur=num_col_tur;
        if(num_filas_exec!=0){
            this.reservasExecutiva = new int[num_filas_exec][num_col_exec];
        }
        this.reservasTuristica = new int[num_filas_tur][num_col_tur];
    }
    
    public String getFlightCode() {
        return flightCode;
    }
    public int[][] getReservasExecutiva() {
        return reservasExecutiva;
    }
    public void setReservasExecutiva(int[][] reservasExecutiva) {
        this.reservasExecutiva = reservasExecutiva;
    }
    public int[][] getReservasTuristica() {
        return reservasTuristica;
    }
    public void setReservasTuristica(int[][] reservasTuristica) {
        this.reservasTuristica = reservasTuristica;
    }
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
    public ClassPlane getPlane() {
        return plane;
    }
    public void setPlane(ClassPlane plane) {
        this.plane = plane;
    }
    
    public int getNum_filas_exec() {
        return num_filas_exec;
    }
    public void setNum_filas_exec(int num_filas_exec) {
        this.num_filas_exec = num_filas_exec;
    }
    public int getNum_col_exec() {
        return num_col_exec;
    }
    public void setNum_col_exec(int num_col_exec) {
        this.num_col_exec = num_col_exec;
    }
    public int getNum_filas_tur() {
        return num_filas_tur;
    }
    public void setNum_filas_tur(int num_filas_tur) {
        this.num_filas_tur = num_filas_tur;
    }
    public int getNum_col_tur() {
        return num_col_tur;
    }
    public void setNum_col_tur(int num_col_tur) {
        this.num_col_tur = num_col_tur;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((flightCode == null) ? 0 : flightCode.hashCode());
        result = prime * result + ((plane == null) ? 0 : plane.hashCode());
        result = prime * result + num_filas_exec;
        result = prime * result + num_col_exec;
        result = prime * result + num_filas_tur;
        result = prime * result + num_col_tur;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plane other = (Plane) obj;
        if (flightCode == null) {
            if (other.flightCode != null)
                return false;
        } else if (!flightCode.equals(other.flightCode))
            return false;
        if (plane != other.plane)
            return false;
        if (num_filas_exec != other.num_filas_exec)
            return false;
        if (num_col_exec != other.num_col_exec)
            return false;
        if (num_filas_tur != other.num_filas_tur)
            return false;
        if (num_col_tur != other.num_col_tur)
            return false;
        return true;
    }
    @Override
    public String toString() {
        int numSeatsExecutive = num_col_exec*num_filas_exec;
        int numSeatsTourist = num_col_tur*num_filas_tur;
        if(numSeatsExecutive==0){
            return "\nFlightCode=" + flightCode + ", Class=" + plane 
            + ", NumSeatsTourist=" + numSeatsTourist; 
        }
        return "\nFlightCode=" + flightCode + ", Class=" + plane + ", NumSeatsExecutive=" + numSeatsExecutive
        + ", NumSeatsTourist=" + numSeatsTourist; 
    }
    
    
}