package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.WorkingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTableRepository extends JpaRepository<WorkingTable, Long> {
    public WorkingTable findByNumber(long number);
}
