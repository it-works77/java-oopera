package controller;

import model.*;
import util.PersonsGenerator;
import util.ShowGenerator;

import java.util.ArrayList;

public class ApplicationController {
    private ArrayList<Show> shows;
    private ArrayList<Director> directors;
    private ArrayList<Person> musicAuthors;
    private ArrayList<Person> choreographers;
    private ArrayList<Actor> actors;

    public void prepareShows() {
        directors = PersonsGenerator.generateDirectors();

        // Также создайте одного автора музыки и одного хореографа
        musicAuthors = PersonsGenerator.generateMusicAuthors();
        choreographers = PersonsGenerator.generateChoreographers();

        // Создать три спектакля: обычный, оперный и балет
        shows = ShowGenerator.generate(directors, choreographers, musicAuthors);
    }

    public void prepareActors() {
        actors = PersonsGenerator.generateActors();
    }

    public void distributeActors() {
        for (Show s : shows) {
            if (s.getTitle().equals(ShowGenerator.SHOWS[2])) {
                // Не добавляем первого актера (Хабенский), чтобы продемонстрировать функцию замены
                ArrayList<Actor> al = new ArrayList<>(actors);
                al.removeFirst();
                ShowGenerator.addActorsToShow(s, al);
                continue;
            }
            ShowGenerator.addActorsToShow(s, actors);
        }
    }

    public void substituteActor(Show showFrom, Show showTo, String sourceActorSurname, String destinationActorSurname) {
        Actor sourceActor = showFrom.getActor(sourceActorSurname);
        if (sourceActor == null) {
            System.out.println("В спектакле " + showFrom.getTitle() + " нет актера " + sourceActorSurname);
            return;
        }

        showTo.substituteActor(sourceActor, destinationActorSurname);
    }

    public Show getShow(String title) {
        Show show;
        int showIndex = -1;
        for (int i = 0; i < shows.size(); i++) {
            show = shows.get(i);
            if (show.getTitle().equals(title)) {
                showIndex = i;
            }
        }
        if (showIndex == -1) {
            return null;
        }
        return shows.get(showIndex);
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void printGreeting() {
        System.out.println("Поехали!");
    }

    public void printSubstitutionInfo(Show showFrom,
                                      Show showTo,
                                      String sourceActorSurname,
                                      String destinationActorSurname) {
        System.out.println("Заменяем актера " + destinationActorSurname
                + " в спектакле '" + showTo.getTitle()
                + "' на актера " + sourceActorSurname
                + " из спектакля '" + showFrom.getTitle() + "'");
    }

    public void printAllShowActors() {
        for (Show s : shows) {
            System.out.println();
            System.out.println("Актеры спектакля " + s.getTitle() + ":");
            ArrayList<Actor> actorList = s.getListOfActors();
            for (Actor a : actorList) {
                System.out.println(a);
            }
        }
    }

    public void printLibretto() {
        System.out.println();
        for (Show s : shows) {
            if (s instanceof MusicalShow) {
                System.out.println("Либретто спектакля '" + s.getTitle() + "': " + ((MusicalShow) s).getLibrettoText());
            }
        }
    }
}
