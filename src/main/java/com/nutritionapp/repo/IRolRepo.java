package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Rol;

//@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer>{

}
