package tn.esprit.chakrounnassim4ds3.services;

import tn.esprit.chakrounnassim4ds3.entities.Skier;

import java.util.List;

public interface ISkierServices {

    Skier getSkier(long id);
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    void removeSkier(long id);
    List<Skier> getSkiers();
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
}
