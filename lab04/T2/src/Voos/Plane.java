package Voos;

public class Plane {
    private int touristRows;
    private int seatsPerRowOnTourist;
    private int executiveRows;
    private int seatsPerRowOnExecutive;

    
    public Plane(int touristRows,int seatsPerRowOnTourist) {
        this.touristRows = touristRows;
        this.seatsPerRowOnTourist= seatsPerRowOnTourist;
    }

    
    public Plane(int touristRows, int seatsPerRowOnTourist, int executiveRows, int seatsPerRowOnExecutive ) {
        this.touristRows = touristRows;
        this.seatsPerRowOnTourist= seatsPerRowOnTourist;
        this.executiveRows = executiveRows;
        this.seatsPerRowOnExecutive = seatsPerRowOnExecutive  ;
    }

    
    public int getTouristRows() {
        return touristRows;
    }

    public int getSeatsPerRowOnTourist() {
        return seatsPerRowOnTourist;
    }

    public int getExecutiveRows() {
        return executiveRows;
    }

    public int getSeatsPerRowOnExecutive  () {
        return seatsPerRowOnExecutive ;
    }
}
