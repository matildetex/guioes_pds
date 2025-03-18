package B;

class Employee {
    private Person person;
    private double salary;
    private BankAccount bankAccount;

    public Employee(Person person, double salary) {
        this.person = person;
        this.salary = salary;
        this.bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }

    public Person getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
