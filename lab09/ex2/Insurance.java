import java.util.ArrayList;
import java.util.List;

public class Insurance {
    private List<Person> list_personsensured;

    public Insurance() {
        list_personsensured = new ArrayList<>();
    }

    public void regist(Person p) {
        list_personsensured.add(p);
        System.out.println("Employee " + p.getName() + " registered in Insurance with success!");
    }
}
