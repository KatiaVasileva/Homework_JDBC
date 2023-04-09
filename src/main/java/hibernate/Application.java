package hibernate;

import hibernate.dao.CityDAO;
import hibernate.dao.CityDAOImpl;
import hibernate.dao.EmployeeDAO;
import hibernate.dao.EmployeeDAOImpl;
import hibernate.model.City;
import hibernate.model.Employee;

public class Application {
    public static void main(String[] args) {

    // Условия домашнего задания:
    // 1 Приведите оба класса (Employee и City) к требованиям Entity.
    // 2. Свяжите сущности между собой так, чтобы из одного города могло быть несколько сотрудников,
    // а один сотрудник — только из одного города.
    // 3. Включите полную каскадность.
    // 4. Выберите Fetch Type и объясните свое решение в комментарии к ДЗ.
    // 5. Сформируйте слой DAO для сущности City с необходимыми CRUD-методами.

        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    // 6. Создайте объект City и несколько объектов Employee. Укажите сотрудников в объекте City.
    // Сохраните город и убедитесь, что сотрудники тоже сохранились в базе данных.

        City city1 = new City("Los Angeles");
        cityDAO.addCity(city1);
        Employee employee1 = new Employee("Stuart", "Nelson", "male", 45);
        employee1.setCity(city1);
        city1.addEmployeeToCity(employee1);
        Employee employee2 = new Employee("Martha", "Griggs", "female", 36);
        employee2.setCity(city1);
        city1.addEmployeeToCity(employee2);
        cityDAO.updateCity(city1);

        // Проверка сохранения города и сотрудников
        System.out.println("The city has been saved: " + cityDAO.getAllCities().contains(city1)); // true
        System.out.println("The employee has been saved in the city: "
                + cityDAO.getCityById(city1.getId()).getEmployees().contains(employee1)); // true
        System.out.println("The employee has been saved in the city: "
                + cityDAO.getCityById(city1.getId()).getEmployees().contains(employee2)); // true

    // 7. Замените одного из сотрудников в городе, обновите сущность в базе данных и убедитесь,
    // что сотрудник изменился в БД.
        Employee newEmployee1 = new Employee("Jake", "Donn", "male", 26);
        city1.changeEmployeeInCity(employee1, newEmployee1);
        cityDAO.updateCity(city1);

        // Проверка изменения сотрудника
        System.out.println("The employee has been changed: "
                + cityDAO.getCityById(city1.getId()).getEmployees().contains(newEmployee1)); // true

    // 8. Удалите экземпляр City из базы данных и убедитесь, что и город, и ссылающиеся на него сотрудники удалены.
        cityDAO.deleteCity(city1);

        // Проверка удаления города и ссылающихся на него сотрудников
        System.out.println("The city hasn't been deleted: " + cityDAO.getAllCities().contains(city1)); // false
        System.out.println("The employee contained in the deleted city hasn't been deleted: "
                + employeeDAO.getAllEmployees().contains(newEmployee1)); // false
        System.out.println("The employee contained in the deleted city hasn't been deleted: "
                + employeeDAO.getAllEmployees().contains(employee2)); // false
    }
}
