package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.PublicRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicRoomRepository extends MongoRepository<PublicRoom, Long> {
}
