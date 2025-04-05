package tn.esprit.chakrounnassim4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import tn.esprit.chakrounnassim4ds3.entities.Subscription;
import tn.esprit.chakrounnassim4ds3.entities.TypeSubscription;
import tn.esprit.chakrounnassim4ds3.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {

    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        List<Subscription> subscriptions = subscriptionRepository.findAll()
                .stream()
                .filter(sub -> sub.getTypeSub() == type)
                .sorted(Comparator.comparing(Subscription::getStartDate))
                .collect(Collectors.toList());

        return new LinkedHashSet<>(subscriptions);
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        List<Subscription> subscriptionsByDates = new ArrayList<>();
        for (Subscription sub : subscriptions) {
            if (sub.getStartDate().isAfter(startDate) && sub.getEndDate().isBefore(endDate)) {
                subscriptionsByDates.add(sub);
            }
        }
        return subscriptionsByDates;
    }
}
