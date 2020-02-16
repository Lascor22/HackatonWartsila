package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.ObjectMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/0")
public abstract class ObjectMapController {

    public ObjectMapController(){}

//    public abstract ObjectMap findById();
}
