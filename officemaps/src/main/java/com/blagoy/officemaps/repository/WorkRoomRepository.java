package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.WorkRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkRoomRepository extends MongoRepository<WorkRoom, Long> {
}
