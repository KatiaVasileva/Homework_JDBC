package homework_4;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "12345";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT first_name, " +
                     "last_name, gender, age, city_id FROM employee WHERE id = 1");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("Gender: " + resultSet.getString("gender"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("City ID: " + resultSet.getInt("city_id"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }
}
