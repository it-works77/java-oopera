package model;

import java.util.Objects;

public class Actor extends Person {
    // Рост логично вынести в Person, но по ТЗ - это единственный атрибут актера:
    // "Для актёра добавим поля имя (name), фамилия (surname), пол (gender) и рост (height)"
    private final int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Actor actor = (Actor) o;
        return height == actor.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }

    @Override
    public String toString() {
        // ТЗ: Для каждого актёра при этом должны выводиться имя и фамилия, а также в скобках его рост.
        // Для вывода имени, фамилии и роста также обдумайте использование метода toString
        return super.getName() + " " + super.getSurname() + " (" + height + ")";
    }
}
