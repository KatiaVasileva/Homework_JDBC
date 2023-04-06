package jdbc.service;

import jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void updateEmployee(int id, Employee employee);

    void removeEmployee(int id);
}
