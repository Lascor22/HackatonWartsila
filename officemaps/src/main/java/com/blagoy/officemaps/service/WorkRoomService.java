package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.repository.WorkRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRoomService {

    private final WorkRoomRepository workRoomRepository;

    public WorkRoomService(WorkRoomRepository workRoomRepository) {
        this.workRoomRepository = workRoomRepository;
    }

    public List<WorkRoom> findAll() {
        return workRoomRepository.findAll();
    }

    public WorkRoom findById(long id) {
        return workRoomRepository.findById(id).orElse(null);
    }
}
