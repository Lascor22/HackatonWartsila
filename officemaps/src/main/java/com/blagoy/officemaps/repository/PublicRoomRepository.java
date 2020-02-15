package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.PublicRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicRoomRepository extends JpaRepository<PublicRoom, Long> {
}
