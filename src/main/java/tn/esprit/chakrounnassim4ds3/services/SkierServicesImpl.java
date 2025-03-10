package tn.esprit.chakrounnassim4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.chakrounnassim4ds3.entities.Skier;
import tn.esprit.chakrounnassim4ds3.repositories.ISkierRepository;

import java.util.List;

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
}
