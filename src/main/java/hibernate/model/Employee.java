package hibernate.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

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

    public Employee(String firstName,
                    String lastName,
                    String gender,
                    int age,
                    City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "#" + getId() + ": " + getFirstName() + ", " + getLastName() + ", " +
                getGender() + ", " + getAge() + ", " + getCity();
    }
}
