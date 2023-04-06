package hibernate.model;

import java.util.Objects;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(length = 6, nullable = false)
    private String gender;
    @Column(nullable = false)
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Employee(String firstName,
                    String lastName,
                    String gender,
                    int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "#" + getId() + ": " + getFirstName() + ", " + getLastName() + ", " +
                getGender() + ", " + getAge() + ", " + getCity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && gender.equals(employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender);
    }
}
