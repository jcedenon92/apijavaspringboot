package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Alimento;

//@Repository
public interface IAlimentoRepo extends JpaRepository<Alimento, Integer>{

}
