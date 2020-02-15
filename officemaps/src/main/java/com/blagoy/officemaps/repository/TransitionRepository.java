package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Transition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitionRepository extends JpaRepository<Transition, Long> {
}
