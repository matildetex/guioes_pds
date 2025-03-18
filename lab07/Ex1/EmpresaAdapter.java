package lab07.Ex1;

import java.util.List;

// Classe Adapter
class EmpresaAdapter {
    private Database database;
    private Registos registos;

    public EmpresaAdapter(Database database, Registos registos) {
        this.database = database;
        this.registos = registos;
    }

    // Método para adicionar um empregado
    public void addEmployee(Employee employee) {
        database.addEmployee(employee);
    }

    // Método para remover um empregado, dado o número de funcionário
    public void removeEmployee(long emp_num) {
        database.deleteEmployee(emp_num);
    }

    // Método para verificar se um empregado existe na empresa, dado o número do empregado
    public boolean employeeExists(int codigo) {
        return registos.isEmpregado(codigo);
    }

    // Método para imprimir os registros de todos os funcionários
   // Método para imprimir os registros de todos os funcionários
   public void printAllEmployees() {
    Employee[] employees = database.getAllEmployees();
    for (Employee emp : employees) {
        System.out.println("Name: " + emp.getName() + "; Employee Number: " + emp.getEmpNum() + "; Salary: " + emp.getSalary());
    }

    List<Empregado> empregados = registos.listaDeEmpregados();
    for (Empregado emp : empregados) {
        System.out.println("Nome: " + emp.nome() + "; Sobrenome: " + emp.apelido() + "; Código: " + emp.codigo() + "; Salário: " + emp.salario());
    }
}
}