package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.WorkingTable;
import com.blagoy.officemaps.form.WorkingTableForm;
import com.blagoy.officemaps.repository.WorkingTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTableService {
    private final WorkingTableRepository workingTableRepository;
    private final WorkRoomService workRoomService;

    public WorkingTableService(WorkingTableRepository workingTableRepository, WorkRoomService workRoomService) {
        this.workingTableRepository = workingTableRepository;
        this.workRoomService = workRoomService;
    }

    public List<WorkingTable> findAll() {
        return workingTableRepository.findAll();
    }

    public WorkingTable findById(long id) {
        return workingTableRepository.findById(id).orElse(null);
    }

    public WorkingTable findByNumber(long number) {
        return workingTableRepository.findByNumber(number);
    }

    public void createWorkingTable(WorkingTableForm workingTableForm) {
        WorkingTable workingTable = new WorkingTable();
        workingTable.setNumber(workingTableForm.getNumber());
        workingTableRepository.save(workingTable);
    }
}
