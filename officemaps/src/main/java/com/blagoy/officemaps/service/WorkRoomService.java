package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Floor;
import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.domain.WorkingTable;
import com.blagoy.officemaps.form.WorkRoomForm;
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

    public void createWorkRoom(WorkRoomForm workRoomForm, Floor floor) {
        WorkRoom workRoom = new WorkRoom();
        workRoom.setNumber(workRoomForm.getNumber());
        workRoom.setPoint(workRoomForm.getPoint());
        workRoom.setFloor(floor);
        workRoom.setWidth(workRoomForm.getWidth());
        workRoom.setHeight(workRoomForm.getHeight());
        workRoom.setDoors(workRoomForm.getDoors());
        workRoom.setNeighbors(workRoomForm.getNeighbors());
        workRoomRepository.save(workRoom);
    }
}
