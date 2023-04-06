package hibernate;

import hibernate.dao.CityDAO;
import hibernate.dao.CityDAOImpl;
import hibernate.model.City;
import hibernate.model.Employee;
import hibernate.dao.EmployeeDAO;
import hibernate.dao.EmployeeDAOImpl;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

       /* insertSeparator1();
        // добавляем новую строку в таблицу и выводим всю таблицу в консоль
        System.out.println("Задача 1. Создать (добавить) сущность Employee в таблицу");
        insertSeparator2();
        employeeDAO.addEmployee(new Employee("Margareth", "Thatcher", "female", 88,
                new City("London")));
        List<Employee> employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        insertSeparator1();
        // получаем объект по id и выводим его в консоль
        System.out.println("Задача 2. Получить конкретный объект Employee по id"); // совпадает c заданием 4 из пункта 1
        insertSeparator2();
        Employee employee = employeeDAO.getEmployeeById(1);
        System.out.println(employee);

        insertSeparator1();
        System.out.println("Задача 3. Получить список всех объектов Employee");
        insertSeparator2();
        employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        insertSeparator1();
        // изменяем объект и выводим полученную строку в консоль
        System.out.println("Задача 4. Изменить объект Employee в базе по id");
        insertSeparator2();
        employeeDAO.updateEmployee(new Employee("Jane", "Tanes", "female", 44,
                new City("New York")));
        System.out.println(employeeDAO.getEmployeeById(10));

        insertSeparator1();
        // удаляем конкретный объект по id и выводим оставшиеся строки в консоль
        System.out.println("Задача 5. Удалить конкретный объект Employee в базе по id");
        insertSeparator2();
        employeeDAO.deleteEmployee(14);
        employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        insertSeparator1();*/

        City city = new City("Los Angeles");
        cityDAO.addCity(city);
        Employee employee1 = new Employee("Stuart", "Nelson", "male", 45);
        employee1.setCity(city);
        city.addEmployeeToCity(employee1);
        Employee employee2 = new Employee("Martha", "Griggs", "female", 36);
        employee2.setCity(city);
        city.addEmployeeToCity(employee2);
        Employee employee3 = new Employee("Walter", "Disney", "male", 69);
        employee3.setCity(city);
        city.addEmployeeToCity(employee3);
        cityDAO.updateCity(city);
    }

    public static void insertSeparator1() {
        System.out.println("====================================================================================");
    }

    public static void insertSeparator2() {
        System.out.println("...................................................................................");
    }
}
