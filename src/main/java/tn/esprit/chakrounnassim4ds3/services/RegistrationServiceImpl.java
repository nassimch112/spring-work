package tn.esprit.chakrounnassim4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.Course;
import tn.esprit.chakrounnassim4ds3.entities.Registration;
import tn.esprit.chakrounnassim4ds3.entities.Skier;
import tn.esprit.chakrounnassim4ds3.entities.TypeCourse;
import tn.esprit.chakrounnassim4ds3.repositories.ICourseRepository;
import tn.esprit.chakrounnassim4ds3.repositories.IRegistrationRepository;
import tn.esprit.chakrounnassim4ds3.repositories.ISkierRepository;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    private ISkierRepository skierRepository;
    private IRegistrationRepository registrationRepository;
    private ICourseRepository courseRepository;

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        Registration registration = registrationRepository.findById(numRegistration).orElse(null);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        Course course = courseRepository.findById(numCourse).orElse(null);

        int skierAge = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears();

        if (course.getRegistrations().size() <= 6 && (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN || course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT)) {
            registration.setSkier(skier);
            registration.setCourse(course);
        }
        return registrationRepository.save(registration);
    }


}
