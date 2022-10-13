package com.incubyte.subscriber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubscriberServiceShould {

  @Mock SubscriberRepository subscriberRepository;

  @Test
  @DisplayName("should invoke repository save method")
  void should_save_subscriber_details() {
    Subscriber subscriber = new Subscriber("abdul@gmail.com", "Abdul", "Kalam");
    SubscriberService subscriberService = new SubscriberService(subscriberRepository);
    subscriberService.save(subscriber);
    Mockito.verify(subscriberRepository).save(subscriber);
  }

  @Test
  @DisplayName("should invoke repository getById method")
  void should_get_subscriber_details() {
    SubscriberService subscriberService = new SubscriberService(subscriberRepository);
    subscriberService.getById(12L);
    Mockito.verify(subscriberRepository).findById(12L);
  }
}
