package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FloorRepository extends MongoRepository<Floor, Long> {
}
