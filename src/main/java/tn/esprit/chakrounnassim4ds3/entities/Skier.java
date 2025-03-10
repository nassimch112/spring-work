package tn.esprit.chakrounnassim4ds3.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Skier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numSkier;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String city;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Subscription subscription;

    @OneToMany(mappedBy = "skier")
    Set<Registration> registration;

    @ManyToMany(mappedBy = "skiers")
    Set<Piste> pistes;

}
