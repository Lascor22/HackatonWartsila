package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.WorkingTable;
import com.blagoy.officemaps.form.WorkingTableForm;
import com.blagoy.officemaps.service.WorkRoomService;
import com.blagoy.officemaps.service.WorkingTableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class WorkingTableController {
    private final WorkingTableService workingTableService;
    private final WorkRoomService workRoomService;

    public WorkingTableController(WorkingTableService workingTableService, WorkRoomService workRoomService) {
        this.workingTableService = workingTableService;
        this.workRoomService = workRoomService;
    }

    @GetMapping("workingTables")
    public List<WorkingTable> findAll() {
        return workingTableService.findAll();
    }

    @GetMapping("workingTable/{id}")
    public WorkingTable findById(@PathVariable("id") long id) {
        return workingTableService.findById(id);
    }

    @PostMapping("workingTable")
    public void createWorkingTable(@RequestBody WorkingTableForm workingTableForm) {
        workingTableService.createWorkingTable(workingTableForm);
    }

}
