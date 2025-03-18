package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car { // добавлен entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return model + " " + series;
    }
}
