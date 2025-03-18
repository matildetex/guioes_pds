package B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();

    public void admitEmployee(Person person, double salary) {
        Employee employee = new Employee(person, salary);
        emps.add(employee);
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            e.getBankAccount().deposit(e.getSalary());
        }
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}
