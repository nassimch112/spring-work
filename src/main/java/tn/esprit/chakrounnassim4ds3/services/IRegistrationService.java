package tn.esprit.chakrounnassim4ds3.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.Registration;

public interface IRegistrationService {
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
}
