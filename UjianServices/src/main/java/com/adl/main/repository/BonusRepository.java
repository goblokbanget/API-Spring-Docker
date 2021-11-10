package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.main.model.BonusModel;

@Repository
public interface BonusRepository extends JpaRepository<BonusModel, Integer> {

}
