package tn.esprit.chakrounnassim4ds3.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.Registration;
import tn.esprit.chakrounnassim4ds3.entities.Skier;
import tn.esprit.chakrounnassim4ds3.repositories.IRegistrationRepository;
import tn.esprit.chakrounnassim4ds3.repositories.ISkierRepository;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    private ISkierRepository skierRepository;
    private IRegistrationRepository registrationRepository;


    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }
}
