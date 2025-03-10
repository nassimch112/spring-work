package tn.esprit.chakrounnassim4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.Course;
import tn.esprit.chakrounnassim4ds3.entities.Instructor;
import tn.esprit.chakrounnassim4ds3.repositories.ICourseRepository;
import tn.esprit.chakrounnassim4ds3.repositories.IInstructorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements IInstructorServices{

    private IInstructorRepository instructorrepository;
    private ICourseRepository courseRepository;

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

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        if (instructor.getCourses() != null) {
            instructor.getCourses().add(course);
        }
        else
        {
            Set<Course> courses = new HashSet<>();
            courses.add(course);
            instructor.setCourses(courses);
        }
        return instructorrepository.save(instructor);
    }
}
