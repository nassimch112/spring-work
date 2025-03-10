package tn.esprit.chakrounnassim4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.Instructor;
import tn.esprit.chakrounnassim4ds3.repositories.IInstructorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements IInstructorServices{

    private IInstructorRepository instructorrepository;
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorrepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorrepository.save(instructor);
    }

    @Override
    public Instructor getInstructor(long numInstructor) {
        return instructorrepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(long numInstructor) {
        instructorrepository.deleteById(numInstructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorrepository.findAll();
    }
}
