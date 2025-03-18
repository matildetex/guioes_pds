package lab08.Ex1;

import java.sql.Date;
// Decoradores concretos
class TeamLeader extends EmployeeDecorator {
    public TeamLeader(DecoratorInterface employee) {
        super(employee);
    }

    @Override
    public void start(Date date) {
        employee.start(date);
        System.out.println("Team Leader started on " + date);
    }

    @Override
    public void terminate(Date date) {
        employee.terminate(date);
        System.out.println("Team Leader terminated on " + date);
    }

    @Override
    public void work() {
        employee.work();
        System.out.println("Team Leader is working.");
    }

    public void plan() {
        System.out.println("Team Leader is planning.");
    }
}
