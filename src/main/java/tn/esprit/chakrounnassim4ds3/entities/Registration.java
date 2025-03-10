package tn.esprit.chakrounnassim4ds3.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numRegistration;
    int numWeek;

    @ManyToOne
    Skier skier;

    @ManyToOne
    Course course;
}
