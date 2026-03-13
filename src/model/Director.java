package model;

import java.util.Objects;

public class Director extends Person {
    private final int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    // Так предложено в ТЗ: "Нам нужно описание объекта класса в виде строки,
    // поэтому есть смысл переопределить для этого метод toString"
    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Director director = (Director) o;
        return numberOfShows == director.numberOfShows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfShows);
    }
}
