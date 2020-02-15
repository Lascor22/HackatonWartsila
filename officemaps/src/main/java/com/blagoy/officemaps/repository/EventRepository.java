package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, Long> {


}
