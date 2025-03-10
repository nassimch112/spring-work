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
}
