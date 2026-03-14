package model;

import controller.ApplicationController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import util.PersonsGenerator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ShowTest {
    private ArrayList<Show> shows;
    private ArrayList<Actor> actors;
    private Actor notExistingActor;

    @BeforeEach
    void setUp() {
        ApplicationController ac = new ApplicationController();
        ac.prepareShows();
        shows = ac.getShows();
        actors = PersonsGenerator.generateActors();
        int HEIGHT = 180;
        notExistingActor = new Actor("AAA", "BBB", Gender.MALE, HEIGHT);
    }

    @org.junit.jupiter.api.Test
    void addNewActor() {
        Show s = shows.getFirst();
        s.addActor(notExistingActor);
        assertTrue(s.getListOfActors().contains(notExistingActor));
    }

    @org.junit.jupiter.api.Test
    void addExistingActor() {
        Show s = shows.getFirst();
        s.addActor(actors.getFirst());

        int actorsNumBefore = s.getListOfActors().size();

        s.addActor(actors.getFirst());

        // Список актеров не должен измениться при добавлении имеющегося
        assertEquals(actorsNumBefore, s.getListOfActors().size());
    }

    @org.junit.jupiter.api.Test

    void substituteNotExistingActor() {
        Show s = shows.getFirst();
        s.addActor(actors.getFirst());

        Actor actorToSubstitute = s.getListOfActors().getFirst();

        s.substituteActor(notExistingActor, actorToSubstitute.getSurname());
        assertTrue(s.getListOfActors().contains(notExistingActor));
        assertFalse(s.getListOfActors().contains(actorToSubstitute));
    }

    @org.junit.jupiter.api.Test
    void substituteExistingActor() {
        Assertions.fail();
    }
}