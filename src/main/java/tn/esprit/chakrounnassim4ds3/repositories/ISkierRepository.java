package tn.esprit.chakrounnassim4ds3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chakrounnassim4ds3.entities.Skier;

public interface ISkierRepository extends JpaRepository<Skier,Long> {
}
