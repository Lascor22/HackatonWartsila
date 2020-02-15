package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.WorkRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRoomRepository extends MongoRepository<WorkRoom, Long> {
}
