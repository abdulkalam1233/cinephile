package com.incubyte.subscriber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class subscriberControllerShould {

  @Mock SubscriberService subscriberService;

  @Test
  @DisplayName("should invoke service save method")
  void should_invoke_service_save_method() {
    Subscriber subscriber = new Subscriber("abdul@gmail.com", "Abdul", "Kalam");
    SubscriberController controller = new SubscriberController(subscriberService);
    controller.save(subscriber);
    Mockito.verify(subscriberService).save(subscriber);
  }

  @Test
  @DisplayName("should invoke service getById method")
  void should_invoke_service_get_by_id_method() {
    SubscriberController controller = new SubscriberController(subscriberService);
    controller.getById(12L);
    Mockito.verify(subscriberService).getById(12L);
  }
}
