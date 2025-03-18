package lab08.Ex1;

import java.sql.Date;
// Classe abstrata decoradora
abstract class EmployeeDecorator implements DecoratorInterface {
    protected DecoratorInterface employee;
    protected Date data;

    public EmployeeDecorator(DecoratorInterface employee) {
        this.employee = employee;
    }

    public void start(Date date) {
        employee.start(date);   
    }
    @Override
    public void terminate(Date date) {
        employee.terminate(date);
    }

    @Override
    public void work() {
        employee.work();
    }

}