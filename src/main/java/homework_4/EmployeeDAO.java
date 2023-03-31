package homework_4;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(String firstName, String lastName, String gender, int age, City city);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void updateEmployee(int id, int newAge);

    void removeEmployee(int id);
}
