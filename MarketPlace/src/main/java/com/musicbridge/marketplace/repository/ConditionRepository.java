package com.musicbridge.marketplace.repository;

import com.musicbridge.marketplace.domain.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition,Integer> {
}
