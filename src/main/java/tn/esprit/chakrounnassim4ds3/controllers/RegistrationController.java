package tn.esprit.chakrounnassim4ds3.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chakrounnassim4ds3.entities.Registration;
import tn.esprit.chakrounnassim4ds3.services.IRegistrationService;

@AllArgsConstructor
@RestController
@RequestMapping("registration")
public class RegistrationController {
    private IRegistrationService registrationService;

    @PostMapping("add/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration, @PathVariable Long numSkier) {
        return registrationService.addRegistrationAndAssignToSkier(registration, numSkier);
    }


    @PostMapping("assign/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(@PathVariable Long numRegistration, @PathVariable Long numCourse) {
        return registrationService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("add/{numSkier}/{numCourse}")
    public Registration addRegistrationAndAssignToSkierAndCourse(@RequestBody Registration registration, @PathVariable Long numSkier, @PathVariable Long numCourse) {
        return registrationService.addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);
    }
}
