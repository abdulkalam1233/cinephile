package com.incubyte.subscriber;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {}
