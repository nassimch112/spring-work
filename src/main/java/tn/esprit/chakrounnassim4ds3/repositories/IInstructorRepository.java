package tn.esprit.chakrounnassim4ds3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chakrounnassim4ds3.entities.Instructor;

public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
}
