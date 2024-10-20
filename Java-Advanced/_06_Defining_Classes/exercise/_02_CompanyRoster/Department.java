package _02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAvgSalary() {
        return employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
