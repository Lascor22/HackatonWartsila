package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.ObjectMap;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ObjectMapRepository extends MongoRepository<ObjectMap, Long> {
}
