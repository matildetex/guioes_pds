package lab07.Ex1;

// Main class para testar
public class Main {
    public static void main(String[] args) {
        // Criando objetos das classes Database e Registos
        Database database = new Database();
        Registos registos = new Registos();

        // Criando adaptador
        EmpresaAdapter adapter = new EmpresaAdapter(database, registos);

        // Adicionando empregados usando o adaptador
        adapter.addEmployee(new Employee("John", 123, 2500));
        adapter.addEmployee(new Employee("Alice", 456, 3000));
        adapter.addEmployee(new Employee("Bob", 789, 2000));

        // Removendo um empregado usando o adaptador
        adapter.removeEmployee(123);

        // Verificando se um empregado existe usando o adaptador
        System.out.println("Employee with code 789 exists: " + adapter.employeeExists(789));

        // Imprimindo todos os funcionários usando o adaptador
        adapter.printAllEmployees();
    }
}

