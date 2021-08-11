package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.TurnoComida;

//@Repository
public interface ITurnoComidaRepo extends JpaRepository<TurnoComida, Integer>{

}
