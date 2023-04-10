package hibernate.dao;

import hibernate.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void updateEmployeeById(int id, Employee employee);

    void deleteEmployee(int id);
}
