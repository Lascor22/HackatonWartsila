package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Door;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoorRepository extends JpaRepository<Door, Long> {
}
