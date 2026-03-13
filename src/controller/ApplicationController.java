package controller;

import model.Director;
import model.Person;
import model.Show;
import util.PersonsGenerator;
import util.ShowGenerator;

import java.util.ArrayList;

public class ApplicationController {
    public static ArrayList<Show> prepareShows() {
        ArrayList<Director> directors = PersonsGenerator.generateDirectors();

        // Также создайте одного автора музыки и одного хореографа
        ArrayList<Person> musicAuthors = PersonsGenerator.generateMusicAuthors();
        ArrayList<Person> choreographers = PersonsGenerator.generateChoreographers();

        // Создать три спектакля: обычный, оперный и балет
        return ShowGenerator.generate(directors, choreographers, musicAuthors);
    }
}
