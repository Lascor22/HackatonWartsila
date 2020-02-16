package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.repository.ObjectMapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectMapService {

    private final ObjectMapRepository objectMapRepository;

    public ObjectMapService(ObjectMapRepository objectMapRepository) {
        this.objectMapRepository = objectMapRepository;
    }

    public List<? extends ObjectMap> findAll() {
        return objectMapRepository.findAll();
    }

    public ObjectMap findById(long id) {
        return objectMapRepository.findById(id).orElse(null);
    }
}
