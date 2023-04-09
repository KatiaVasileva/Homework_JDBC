package hibernate;

import hibernate.dao.CityDAO;
import hibernate.dao.CityDAOImpl;
import hibernate.model.City;
import hibernate.model.Employee;

public class Application {
    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAOImpl();

        // Создайте объект City и несколько объектов Employee. Укажите сотрудников в объекте City.
        // Сохраните город и убедитесь, что сотрудники тоже сохранились в базе данных.

        City city1 = new City("Los Angeles");
        cityDAO.addCity(city1);
        Employee employee1 = new Employee("Stuart", "Nelson", "male", 45);
        employee1.setCity(city1);
        city1.addEmployeeToCity(employee1);
        Employee employee2 = new Employee("Martha", "Griggs", "female", 36);
        employee2.setCity(city1);
        city1.addEmployeeToCity(employee2);
        Employee employee3 = new Employee("Walter", "Disney", "male", 69);
        employee3.setCity(city1);
        city1.addEmployeeToCity(employee3);
        cityDAO.updateCity(city1);

        City city2 = new City("New York");
        cityDAO.addCity(city2);
        Employee employee4 = new Employee("Karin", "Boye", "female", 37);
        employee4.setCity(city2);
        city2.addEmployeeToCity(employee4);
        Employee employee5 = new Employee("Henry", "Ford", "male", 49);
        employee5.setCity(city2);
        city2.addEmployeeToCity(employee5);
        cityDAO.updateCity(city2);

        // Замените одного из сотрудников в городе, обновите сущность в базе данных и убедитесь,
        // что сотрудник изменился в БД.
        city1.changeEmployeeInTheCity(employee1, new Employee("Jake", "Donn", "male", 26));
        cityDAO.updateCity(city1);
        city2.changeEmployeeInTheCity(employee5, new Employee("Thomas",
                "Crane", "male", 21));
        cityDAO.updateCity(city2);

        // Удалите экземпляр City из базы данных и убедитесь, что и город, и ссылающиеся на него сотрудники удалены.
        cityDAO.deleteCity(city1);
    }
}
