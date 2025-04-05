package tn.esprit.chakrounnassim4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chakrounnassim4ds3.entities.Skier;
import tn.esprit.chakrounnassim4ds3.entities.TypeSubscription;
import tn.esprit.chakrounnassim4ds3.services.ISkierServices;

import java.time.LocalDate;
import java.util.Calendar;

import java.util.Date;
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
        LocalDate startDate = skier.getSubscription().getStartDate();
        TypeSubscription subType = skier.getSubscription().getTypeSub();
        LocalDate endDate = calculateEndDate(startDate, subType);
        skier.getSubscription().setEndDate(endDate);
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

    public static LocalDate calculateEndDate(LocalDate startDate, TypeSubscription subscriptionType) {
        switch (subscriptionType) {
            case ANNUAL:
                return startDate.plusYears(1); // Add 1 year for annual subscription
            case MONTHLY:
                return startDate.plusMonths(1); // Add 1 month for monthly subscription
            case SEMESTRIAL:
                return startDate.plusMonths(6); // Add 6 months for semestrial subscription
            default:
                throw new IllegalArgumentException("Invalid subscription type");
        }
    }

    @PostMapping("add/{numCourse}")
    public Skier addSkierAndAssignToCourse(@RequestBody Skier skier, @PathVariable Long numCourse) {
        return skierService.addSkierAndAssignToCourse(skier, numCourse);
    }

    @GetMapping("bySubscriptionType/{typeSubscription}")
    public List<Skier> retrieveSkiersBySubscriptionType(@PathVariable TypeSubscription typeSubscription){
        return skierService.retrieveSkiersBySubscriptionType(typeSubscription);
    }
}
