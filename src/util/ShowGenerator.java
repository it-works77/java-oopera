package util;

import model.*;

import java.util.ArrayList;

public class ShowGenerator {
    public static final String[] SHOWS = {"Вишнёвый сад", "Евгений Онегин", "Лебединое озеро"};

    public static ArrayList<Show> generate(ArrayList<Director> directors,
                                           ArrayList<Person> choreographers,
                                           ArrayList<Person> musicAuthors) {
        ArrayList<Show> result = new ArrayList<>();

        // Создать три спектакля: обычный, оперный и балет
        result.add(new Show("Вишнёвый сад", 120,
                directors.getFirst())
        );
        result.add(new Opera("Евгений Онегин", 120,
                directors.getLast(),
                "Libretto Text",
                musicAuthors.getFirst(),
                100));
        result.add(new Ballet("Лебединое озеро", 120,
                directors.getLast(),
                "Libretto Text",
                musicAuthors.getFirst(),
                choreographers.getFirst()));

        return result;
    }

    public static void addActorsToShow(Show show, ArrayList<Actor> actors) {
        for (Actor a: actors) {
            show.addActor(a);
        }
    }
}

