package com.incubyte.subscriber;

import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class SubscriberService {

  private final SubscriberRepository subscriberRepository;

  public SubscriberService(SubscriberRepository subscriberRepository) {
    this.subscriberRepository = subscriberRepository;
  }

  public Subscriber save(Subscriber subscriber) {
    return subscriberRepository.save(subscriber);
  }

  public Optional<Subscriber> getById(long id) {
    return subscriberRepository.findById(id);
  }
}
