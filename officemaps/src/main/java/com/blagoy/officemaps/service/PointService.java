package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Point;
import com.blagoy.officemaps.repository.PointRepository;
import org.springframework.stereotype.Service;

@Service
public class PointService {
    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public void save(Point point) {
        pointRepository.save(point);
    }
}
