package jdbc.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode

public class City {
    private int id;
    private String name;

    public City(String name) {
        this.name = name;
    }

    public City(int id) {
        this.id = id;
    }
}
