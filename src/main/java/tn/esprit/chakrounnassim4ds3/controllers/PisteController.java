package tn.esprit.chakrounnassim4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chakrounnassim4ds3.entities.Color;
import tn.esprit.chakrounnassim4ds3.entities.Piste;
import tn.esprit.chakrounnassim4ds3.services.IPisteServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("piste")
public class PisteController {

    private IPisteServices pisteServices;

//    public PisteController(IPisteServices pisteServices) {
//        this.pisteServices = pisteServices;
//    }


    @GetMapping("all")
    public List<Piste> retrieveAllPistes() {
        return pisteServices.getAllPistes();
    }

    @PostMapping("add")
    Piste addPiste(@RequestBody Piste piste) {
        return pisteServices.addPiste(piste);
    }

    @PutMapping("update")
    Piste updatePiste(@RequestBody Piste piste) {
        return pisteServices.updatePiste(piste);
    }

    @DeleteMapping("delete/{numPiste}")
    void deletePiste(@PathVariable("numPiste") Long numPiste) {
        pisteServices.removePiste(numPiste);
    }

    @GetMapping("get/{numPiste}")
    Piste getPisteById(@PathVariable("numPiste") Long numPiste) {
        return pisteServices.getPisteById(numPiste);
    }

    @GetMapping("getByColor/{color}")
    public List<Piste> retrieveAllByColor(@PathVariable("color") Color color) {
        return pisteServices.retrieveAllByColor(color);
    }

    @PutMapping("assignToSkier/{numPiste}/{numSkier}")
    public Piste assignPisteToSkier(@PathVariable Long numPiste, @PathVariable Long numSkier) {
        return pisteServices.assignPisteToSkier(numPiste, numSkier);
    }

}
