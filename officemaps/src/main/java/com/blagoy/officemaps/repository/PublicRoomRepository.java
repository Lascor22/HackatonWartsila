package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.PublicRoom;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface PublicRoomRepository extends MongoRepository<PublicRoom, Long> {
}
