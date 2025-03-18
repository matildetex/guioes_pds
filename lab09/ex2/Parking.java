import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Person> parking;

    public Parking() {
        parking = new ArrayList<>();
    }

    public void allow(Person p) {
        parking.add(p);
        System.out.println("Employee " + p.getName() + " has access to parking.");
    }
}
