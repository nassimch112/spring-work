package tn.esprit.chakrounnassim4ds3.services;

import tn.esprit.chakrounnassim4ds3.entities.Color;
import tn.esprit.chakrounnassim4ds3.entities.Piste;

import java.util.List;

public interface IPisteServices {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste getPisteById(Long numPiste);
    void removePiste(Long numPiste);
    List<Piste> getAllPistes();


    List<Piste> retrieveAllByColor(Color color);

    Piste assignPisteToSkier(Long numPiste, Long numSkier);


}
