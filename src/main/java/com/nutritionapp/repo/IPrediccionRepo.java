package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Prediccion;

//@Repository
public interface IPrediccionRepo extends JpaRepository<Prediccion, Integer>{

}
