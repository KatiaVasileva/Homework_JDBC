package jdbc.service;

import jdbc.config.ConnectionConfig;
import jdbc.model.City;
import jdbc.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(String firstName, String lastName, String gender, int age, City city) {
        Employee employee = new Employee(firstName, lastName, gender, age, city);
        try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(String.format("" +
                "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?));"))) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(String.format("" +
                        "SELECT id, first_name, last_name, gender, age, city_name " +
                     "FROM city RIGHT JOIN employee ON city.city_id = employee.city_id WHERE id = (?);"))) {
            statement.setInt(1, id);
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
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(String.format("" +
                "SELECT id, first_name, last_name, gender, age, city_name FROM city " +
                "RIGHT JOIN employee ON city.city_id = employee.city_id;"))) {
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
    public void updateEmployee(int id, Employee employee) {
        try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(String.format("" +
                "UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?);"))) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getId());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
        }
    }

    @Override
    public void removeEmployee(int id) {
        try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement("" +
                "DELETE FROM employee WHERE id = (?);")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных!");
        }
    }
}
