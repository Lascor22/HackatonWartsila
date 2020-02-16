package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.service.ObjectMapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/0")
public class ObjectMapController {
    private ObjectMapService objectMapService;

    public ObjectMapController(ObjectMapService objectMapService) {
        this.objectMapService = objectMapService;
    }

    @GetMapping("object/{id}")
    public ObjectMap findById(@PathVariable("id") long id) {
        return objectMapService.findById(id);
    }
}
