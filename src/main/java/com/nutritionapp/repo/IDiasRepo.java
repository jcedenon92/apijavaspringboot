package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Dias;

//@Repository
public interface IDiasRepo extends JpaRepository<Dias, Integer>{

}
