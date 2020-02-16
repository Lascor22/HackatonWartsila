package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}
