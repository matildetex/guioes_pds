package lab08.Ex1;

import java.sql.Date;

// Classe base concreta
class Employee implements DecoratorInterface {

    private String name;
    private int ID;

    public Employee(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }   

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void start(Date date) {
        System.out.println("Employee " + name + " started on " + date);
    }

    @Override
    public void terminate(Date date) {
        System.out.println("Employee " + name + " terminated on " + date);
    }

    @Override
    public void work() {
        System.out.println("Employee " + name + " is working");
    }

    
}