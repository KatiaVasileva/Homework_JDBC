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
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
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
}
