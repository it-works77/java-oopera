package util;

import model.Actor;
import model.Director;
import model.Gender;
import model.Person;

import java.util.ArrayList;

public class PersonsGenerator {
    public static final String[] ACTOR_NAMES = {"Константин", "Сергей", "Владимир"};
    public static final String[] ACTOR_SURNAMES = {"Хабенский", "Безруков", "Машков"};

    // ТЗ: только два режиссера
    public static final String[] DIRECTOR_NAMES = {"Римас", "Константин"};
    public static final String[] DIRECTOR_SURNAMES = {"Туминас", "Станиславский"};

    public static ArrayList<Actor> generateActors() {

        assert ACTOR_NAMES.length == ACTOR_SURNAMES.length: "Не хватает фамилий для генерации актеров";

        ArrayList<Actor> result = new ArrayList<>();
        for (int i = 0; i < ACTOR_NAMES.length; i++) {
            result.add(new Actor(ACTOR_NAMES[i], ACTOR_SURNAMES[i], Gender.MALE, 180));
        }
        return result;
    }

    public static ArrayList<Director> generateDirectors() {

        assert DIRECTOR_NAMES.length == DIRECTOR_SURNAMES.length: "Не хватает фамилий для генерации режиссеров";

        ArrayList<Director> result = new ArrayList<>();
        for (int i = 0; i < DIRECTOR_NAMES.length; i++) {
            result.add(new Director(DIRECTOR_NAMES[i], DIRECTOR_SURNAMES[i], Gender.MALE, 180));
        }
        return result;
    }

    public static ArrayList<Person> generateChoreographers() {

        ArrayList<Person> result = new ArrayList<>();
        result.add(new Person("Лев", "Иванов", Gender.MALE));
        return result;
    }

    public static ArrayList<Person> generateMusicAuthors() {

        ArrayList<Person> result = new ArrayList<>();
        result.add(new Person("Петр", "Чайковский", Gender.MALE));
        return result;
    }
}
