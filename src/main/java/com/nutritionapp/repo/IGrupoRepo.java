package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Grupo;

//@Repository
public interface IGrupoRepo extends JpaRepository<Grupo, Integer>{
	
}
