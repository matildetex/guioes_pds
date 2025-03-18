package lab08.Ex1;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        // Criando funcionários básicos
        DecoratorInterface basicEmployee1 = new Employee("John Doe", 144253);
        DecoratorInterface basicEmployee2 = new Employee("Jane Smith", 153242);

        // Decorando funcionários com diferentes responsabilidades
        DecoratorInterface collaboratorEmployee = new TeamMember(basicEmployee1);
        DecoratorInterface plannerEmployee = new TeamLeader(basicEmployee2);
        DecoratorInterface managerEmployee = new Manager(new TeamLeader(new TeamMember(basicEmployee2)));

        // Definindo a data para ações
        java.util.Date currentDateUtil = new java.util.Date(); // Data atual em java.util.Date
        long currentTimeMillis = currentDateUtil.getTime(); // Obtendo o tempo em millis
        Date currentDate = new Date(currentTimeMillis); // Convertendo para java.sql.Date

        // Realizando o trabalho
        collaboratorEmployee.start(currentDate);
        collaboratorEmployee.work();
        collaboratorEmployee.terminate(currentDate);

        plannerEmployee.start(currentDate);
        plannerEmployee.work();
        plannerEmployee.terminate(currentDate);

        managerEmployee.start(currentDate);
        managerEmployee.work();
        managerEmployee.terminate(currentDate);
    }
}
