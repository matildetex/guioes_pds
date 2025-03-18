package lab07.Ex1;

import java.util.Vector;

class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees
    public Database() {
        employees = new Vector<>();
    }
    public boolean addEmployee(Employee employee) {
    // Code to add employee
        if (employees.contains(employee)) {
            return false;
        } else {
            employees.add(employee);
            return true;
        }
    }
    public void deleteEmployee(long emp_num) {
        for (Employee emp : employees) {
            if (emp.getEmpNum() == emp_num) {
                employees.remove(emp);
                break;
            }
        }
    }
    public Employee[] getAllEmployees() {
    // Code to retrieve collection
        if (employees.isEmpty()) {
            return null;
        } else {
            return employees.toArray(new Employee[0]);
        }
    }
    }
    