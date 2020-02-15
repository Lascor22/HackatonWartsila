package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Transition;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface TransitionRepository extends MongoRepository<Transition, Long> {
}
