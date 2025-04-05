package tn.esprit.chakrounnassim4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.chakrounnassim4ds3.entities.Subscription;
import tn.esprit.chakrounnassim4ds3.entities.TypeSubscription;
import tn.esprit.chakrounnassim4ds3.services.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    private ISubscriptionServices subscriptionService;

    @GetMapping("type/{type}")
    public Set<Subscription> getSubscriptionsByType(@PathVariable TypeSubscription type) {
        return subscriptionService.getSubscriptionByType(type);
    }

    @GetMapping("dates/{startDate}/{endDate}")
    public List<Subscription> retrieveSubscriptionsByDates(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return subscriptionService.retrieveSubscriptionsByDates(startDate,endDate);
    }
}
