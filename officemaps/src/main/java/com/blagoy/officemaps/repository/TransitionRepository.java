package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Transition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransitionRepository extends MongoRepository<Transition, Long> {
}
