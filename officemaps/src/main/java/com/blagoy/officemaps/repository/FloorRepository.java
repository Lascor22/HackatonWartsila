package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
    public Floor findByNumber(long number);
}
