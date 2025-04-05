package tn.esprit.chakrounnassim4ds3.services;

import tn.esprit.chakrounnassim4ds3.entities.Subscription;
import tn.esprit.chakrounnassim4ds3.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
