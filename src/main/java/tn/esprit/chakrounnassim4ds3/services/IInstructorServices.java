package tn.esprit.chakrounnassim4ds3.services;

import tn.esprit.chakrounnassim4ds3.entities.Instructor;

import java.util.List;

public interface IInstructorServices {

    Instructor getInstructor(long numInstructor);
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    void deleteInstructor(long numInstructor);
    List<Instructor> getAllInstructors();

}
