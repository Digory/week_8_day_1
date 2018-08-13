package models;

import javax.persistence.*;

@Entity
@Table(name="guitars")
public class Guitar {

    private int id;
    private String colour;
    private int numberOfStrings;

    public Guitar(){}

    public Guitar(String colour, int numberOfStrings) {
        this.colour = colour;
        this.numberOfStrings = numberOfStrings;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="colour")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Column(name="number_of_strings")
    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }
}
