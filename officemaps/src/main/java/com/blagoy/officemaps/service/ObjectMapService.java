package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.repository.ObjectMapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ObjectMapService {

    public ObjectMapService() {}

    public abstract List<? extends ObjectMap> findAll();

    public abstract ObjectMap findById(long id);
}
