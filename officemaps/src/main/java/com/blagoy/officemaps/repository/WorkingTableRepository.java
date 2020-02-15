package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.WorkingTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTableRepository extends MongoRepository<WorkingTable, Long> {
}
