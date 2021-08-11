package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Vacuna;

//@Repository
public interface IVacunaRepo extends JpaRepository<Vacuna, Integer>{

}
