package com.incubyte.subscriber;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
public class subscriberControllerTest {

  @Inject
  @Client("/subscriber")
  HttpClient client;

  @Test
  @DisplayName("Should save subscription details of subscriber")
  void should_save_subscription_details_of_subscriber() {
    Subscriber subscriber = new Subscriber("abdul@gmail.com", "Abdul", "Kalam");
    Subscriber response =
        client.toBlocking().retrieve(HttpRequest.POST("/", subscriber), Subscriber.class);

    assertThat(response.getId()).isGreaterThan(0);
    assertThat(response.getEmail()).isEqualTo("abdul@gmail.com");
    assertThat(response.getFirstName()).isEqualTo("Abdul");
    assertThat(response.getLastName()).isEqualTo("Kalam");
  }

  @Test
  @DisplayName("should get subscriber details")
  void should_get_subscriber_details() {

    Subscriber subscriber = new Subscriber("abdul@gmail.com", "Abdul", "Kalam");
    Subscriber savedSubscriberResponse =
        client.toBlocking().retrieve(HttpRequest.POST("/", subscriber), Subscriber.class);

    Subscriber response =
        client
            .toBlocking()
            .retrieve(HttpRequest.GET("/" + savedSubscriberResponse.getId()), Subscriber.class);

    assertThat(response.getId()).isEqualTo(savedSubscriberResponse.getId());
    assertThat(response.getEmail()).isEqualTo(savedSubscriberResponse.getEmail());
    assertThat(response.getFirstName()).isEqualTo(savedSubscriberResponse.getFirstName());
    assertThat(response.getLastName()).isEqualTo(savedSubscriberResponse.getLastName());
  }
}
