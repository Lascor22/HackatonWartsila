package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.WorkingTable;
import com.blagoy.officemaps.service.WorkingTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class WorkingTableController {
    private final WorkingTableService workingTableService;

    public WorkingTableController(WorkingTableService workingTableService) {
        this.workingTableService = workingTableService;
    }

    @GetMapping("workingTables")
    public List<WorkingTable> findAll() {
        return workingTableService.findAll();
    }

    @GetMapping("workingTable/{id}")
    public WorkingTable findById(@PathVariable long id) {
        return workingTableService.findById(id);
    }

}
