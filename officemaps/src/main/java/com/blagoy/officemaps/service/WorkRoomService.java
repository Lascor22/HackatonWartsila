package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.*;
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

    public void createWorkRoom(long number, Floor floor, double x, double y, double height, double width,
                               List<Door> doors, List<ObjectMap> neighbors) {
        WorkRoom workRoom = new WorkRoom();
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        workRoom.setNumber(number);
        workRoom.setPoint(point);
        workRoom.setFloor(floor);
        workRoom.setWidth(width);
        workRoom.setHeight(height);
        workRoom.setDoors(doors);
        workRoom.setNeighbors(neighbors);
        workRoomRepository.save(workRoom);
    }
}
