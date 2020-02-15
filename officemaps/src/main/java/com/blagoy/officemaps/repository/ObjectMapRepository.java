package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.ObjectMap;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjectMapRepository extends MongoRepository<ObjectMap, Long> {
}
