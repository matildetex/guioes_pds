package lab08.Ex1;

import java.sql.Date;

// Decoradores concretos
class TeamMember extends EmployeeDecorator {
    public TeamMember(DecoratorInterface employee) {
        super(employee);
    }

    @Override
    public void start(Date date) {
        employee.start(date);
        System.out.println("Team Member started on " + date);
    }

    @Override
    public void terminate(Date date) {
        employee.terminate(date);
        System.out.println("Team Member terminated on " + date);
    }

    @Override
    public void work() {
        employee.work();
        System.out.println("Team Member is working.");
    }

    public void collaborate() {
        System.out.println("Team Member is collaborating.");
    }
}
