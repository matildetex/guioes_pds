import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {

	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private SocialSecurity ss = new SocialSecurity();
	private Insurance insurance = new Insurance();
	private EmployeeCard cards = new EmployeeCard();
	private Parking park = new Parking(); 


	public void admitPerson(String name, double salary) {
		Employee e = new Employee(name, salary);
		emps.add(e);
		ss.regist(e);
		insurance.regist(e);
		cards.createCard(e);
		if(salary > averageSalary()){
			park.allow(e);
		}
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public double averageSalary(){
		int sum = 0;
        for (Employee e : emps) {
            sum += e.getSalary();
        }
        double average = (double) sum / emps.size();
        return average;
	}
}