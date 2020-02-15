package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Transition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitionRepository extends MongoRepository<Transition, Long> {
}
