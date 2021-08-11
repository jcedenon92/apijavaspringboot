package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.DetallePlan;

public interface IDetallePlanRepo extends JpaRepository<DetallePlan, Integer> {

}
