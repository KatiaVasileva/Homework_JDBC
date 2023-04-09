package hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;
    @Column(name = "city_name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    // использую стратегию EAGER, чтобы избежать LazyInitializationException при проведении проверок
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

    public void changeEmployeeInCity(Employee employee, Employee newEmployee) {
        removeEmployeeFromCity(employee);
        addEmployeeToCity(newEmployee);
    }

    public void removeEmployeeFromCity(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public String toString() {
        return name;
    }
}
