package hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;
    @Column(name = "city_name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    // отложенная загрузка, чтобы не загружать коллекцию дочерних объектов сразу же,
    // при загрузке родительских объектов и не подгружать из базы лишние объекты-сущности
    private List<Employee> employees;

    public City() {
    }

    public City(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployeeToCity(Employee employee) {
        employee.setCity(this);
        employees.add(employee);
    }

    public void changeEmployeeInTheCity(Employee employee, Employee newEmployee) {
        removeEmployeefromCity(employee);
        addEmployeeToCity(newEmployee);
    }

    public void removeEmployeefromCity(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public String toString() {
        return name;
    }
}
