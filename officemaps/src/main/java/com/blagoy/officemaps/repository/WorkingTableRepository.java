package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.WorkingTable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface WorkingTableRepository extends MongoRepository<WorkingTable, Long> {
    public WorkingTable findByNumber(long number);
}
