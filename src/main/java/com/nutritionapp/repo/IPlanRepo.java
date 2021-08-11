package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Plan;

//@Repository
public interface IPlanRepo extends JpaRepository<Plan, Integer>{

}
