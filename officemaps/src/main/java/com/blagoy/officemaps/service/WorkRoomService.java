package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.form.WorkRoomForm;
import com.blagoy.officemaps.repository.WorkRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRoomService {

    private final WorkRoomRepository workRoomRepository;
    private final PointService pointService;
    private final DoorService doorService;

    public WorkRoomService(WorkRoomRepository workRoomRepository, PointService pointService, DoorService doorService) {
        this.workRoomRepository = workRoomRepository;
        this.pointService = pointService;
        this.doorService = doorService;
    }

    public List<WorkRoom> findAll() {
        return workRoomRepository.findAll();
    }

    public WorkRoom findById(long id) {
        return workRoomRepository.findById(id).orElse(null);
    }

    public WorkRoom findByNumber(long number) {
        return workRoomRepository.findByNumber(number);
    }

    public WorkingTable findWorkingTableByNumber(WorkRoom workRoom, long number) {
        List<WorkingTable> workingTables = workRoom.getWorkingTables();
        for (WorkingTable workingTable : workingTables) {
            if (workingTable.getNumber() == number) {
                return workingTable;
            }
        }
        return null;
    }

    public List<Employee> findAllEmployees(long number) {
        return findByNumber(number).getEmployees();
    }

    public void createWorkRoom(WorkRoomForm workRoomForm, Floor floor) {
        WorkRoom workRoom = new WorkRoom();
        workRoom.setNumber(workRoomForm.getNumber());
        workRoom.setPoint(workRoomForm.getPoint());
        workRoom.setFloor(floor);
        workRoom.setWidth(workRoomForm.getWidth());
        workRoom.setHeight(workRoomForm.getHeight());
        workRoom.setDoors(workRoomForm.getDoors());
        workRoom.setNeighbors(workRoomForm.getNeighbors());
        pointService.save(workRoomForm.getPoint());
        for (Door door : workRoom.getDoors()) {
            doorService.save(door);
        }
        workRoomRepository.save(workRoom);
    }
}
