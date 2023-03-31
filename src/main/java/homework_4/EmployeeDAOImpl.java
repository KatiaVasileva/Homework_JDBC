package homework_4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    final String url = "jdbc:postgresql://localhost:5432/skypro";
    final String user = "postgres";
    final String password = "12345";

    @Override
    public void addEmployee(String firstName, String lastName, String gender, int age, City city) {
        Employee employee = new Employee(firstName, lastName, gender, age, city);
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(String.format("INSERT INTO employee (first_name, " +
                             "last_name, gender, age, city_id) VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() +
                     "', '" + employee.getGender() + "', '" + employee.getAge() + "', '" + city.getCityID() + "');"))) {
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(String.format("SELECT id, first_name, last_name, gender, age, city_name " +
                     "FROM city RIGHT JOIN employee ON city.city_id = employee.city_id WHERE id = " + id + ";"))) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String cityName = resultSet.getString("city_name");

                employee = new Employee(id, firstName, lastName, gender, age, new City(cityName));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(String.format("SELECT id, first_name, last_name, gender, age, city_name " +
                "FROM city RIGHT JOIN employee ON city.city_id = employee.city_id;"))) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String cityName = resultSet.getString("city_name");
                employees.add(new Employee(id, firstName, lastName, gender, age, new City(cityName)));
            }
        } catch(SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
        }
        return employees;
    }

    @Override
    public void updateEmployee(int id, int newAge) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE employee SET age = "
                     + newAge + " WHERE id = " + id + ";")) {
             statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
        }
    }

    @Override
    public void removeEmployee(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = " + id + ";")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
        }
    }
}
