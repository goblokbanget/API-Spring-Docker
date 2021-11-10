package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.main.model.PositionModel;

@Repository
public interface PositionRepository extends JpaRepository<PositionModel, Integer>{

}
