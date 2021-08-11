package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Dosis;

//@Repository
public interface IDosisRepo extends JpaRepository<Dosis, Integer>{

}
