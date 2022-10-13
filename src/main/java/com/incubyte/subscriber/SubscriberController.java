package com.incubyte.subscriber;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.Optional;

@Controller("/subscriber")
public class SubscriberController {

  private final SubscriberService subscriberService;

  public SubscriberController(SubscriberService subscriberService) {
    this.subscriberService = subscriberService;
  }

  @Post
  public Subscriber save(Subscriber subscriber) {
    return subscriberService.save(subscriber);
  }

  @Get("/{subscriberId}")
  public Optional<Subscriber> getById(long subscriberId) {
    return subscriberService.getById(subscriberId);
  }
}
