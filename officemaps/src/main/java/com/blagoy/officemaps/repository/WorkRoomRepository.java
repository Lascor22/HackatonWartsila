package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.WorkRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRoomRepository extends JpaRepository<WorkRoom, Long> {
    public WorkRoom findByNumber(long number);
}
