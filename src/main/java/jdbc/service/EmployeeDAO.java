package jdbc.service;

import jdbc.model.City;
import jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(String firstName, String lastName, String gender, int age, City city);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void updateEmployee(int id, Employee employee);

    void removeEmployee(int id);
}
