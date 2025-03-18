import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCard {
    private UUID id;
    private List<Person> cards_employees;


    public EmployeeCard() {
        this.cards_employees = new ArrayList<>();
    }

    public void createCard(Person p){
        cards_employees.add(p);
        System.out.println("Employee " + p.getName() + " got a card with ID " + this.id);
    }

}
