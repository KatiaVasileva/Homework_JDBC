package homework_4;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        insertSeparator1();
        // добавляем новую строку в таблицу и выводим всю таблицу в консоль
        System.out.println("Задача 1. Создать (добавить) сущность Employee в таблицу");
        insertSeparator2();
        employeeDAO.addEmployee("Lewis", "Bond", "male", 33, new City(6));
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
        // изменяем объект по id и выводим полученную строку в консоль
        System.out.println("Задача 4. Изменить конкретный объект Employee в базе по id"); // изменение возраста
        insertSeparator2();
        employeeDAO.updateEmployee(10, 31);
        System.out.println(employeeDAO.getEmployeeById(10));

        insertSeparator1();
        // удаляем конкретный объект по id и выводим оставшиеся строки в консоль
        System.out.println("Задача 5. Удалить конкретный объект Employee в базе по id");
        insertSeparator2();
        employeeDAO.removeEmployee(7);
        employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        insertSeparator1();
    }

    public static void insertSeparator1() {
        System.out.println("====================================================================================");
    }

    public static void insertSeparator2() {
        System.out.println("...................................................................................");
    }
}
