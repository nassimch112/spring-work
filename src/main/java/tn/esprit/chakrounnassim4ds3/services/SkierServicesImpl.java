package tn.esprit.chakrounnassim4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.*;
import tn.esprit.chakrounnassim4ds3.repositories.ISkierRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SkierServicesImpl implements ISkierServices {


    ISkierRepository skierRepository;

    @Override
    public Skier getSkier(long id) {
        return skierRepository.findById(id).orElse(null);
    }

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public void removeSkier(long id) {
        skierRepository.deleteById(id);
    }

    @Override
    public List<Skier> getSkiers() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Subscription subscription = new Subscription();
        Registration registration = new Registration();
        if (skier.getRegistration() != null) { //TODO get registration from body
            skier.getRegistration().add(registration);
        }
        else
        {
            Set<Registration> registrations = new HashSet<>();
            registrations.add(registration);
            skier.setRegistration(registrations);
        }
        Subscription sub = skier.getSubscription();
        skier.setSubscription(sub);
        skierRepository.save(skier);
        return skier;
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        List<Skier> skiers = skierRepository.findAll();
        List<Skier> skiersBySub = new ArrayList<>();

        for(Skier skier : skiers) {
            if(skier.getSubscription() != null && skier.getSubscription().getTypeSub() == typeSubscription) {
                skiersBySub.add(skier);
            }
        }
        return skiersBySub;
    }
}
