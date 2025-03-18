package lab08.Ex1;

import java.sql.Date;
// Decoradores concretos
class Manager extends EmployeeDecorator {
    public Manager(DecoratorInterface employee) {
        super(employee);
    }

    @Override
    public void start(Date date) {
        employee.start(date);
        System.out.println("Manager started on " + date);
    }

    @Override
    public void terminate(Date date) {
        employee.terminate(date);
        System.out.println("Manager terminated on " + date);
    }

    @Override
    public void work() {
        employee.work();
        System.out.println("Manager is working.");
    }

    public void manage() {
        System.out.println("Manager is managing.");
    }
}

