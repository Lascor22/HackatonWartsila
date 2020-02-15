package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.ObjectMap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectMapRepository extends MongoRepository<ObjectMap, Long> {
}
