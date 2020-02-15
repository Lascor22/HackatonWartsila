package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Floor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface FloorRepository extends MongoRepository<Floor, Long> {
}
