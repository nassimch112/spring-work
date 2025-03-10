package tn.esprit.chakrounnassim4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chakrounnassim4ds3.entities.Skier;
import tn.esprit.chakrounnassim4ds3.services.ISkierServices;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("skier")
public class SkierController {


    private ISkierServices skierService;

    @GetMapping("all")
    public List<Skier> retrieveAll(){
        return skierService.getSkiers();
    }


    @PostMapping("add")
    Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @PutMapping("update")
    Skier updateSkier(@RequestBody Skier skier) {
        return skierService.updateSkier(skier);
    }

    @GetMapping("get/{numSkier}")
    Skier retrieveSkier(@PathVariable("numSkier") Long numSkier) {
        return skierService.getSkier(numSkier);
    }

    @DeleteMapping("remove/{numSkier}")
    void removeSkier(@PathVariable("numSkier") Long numSkier) {
        skierService.removeSkier(numSkier);
    }
}
