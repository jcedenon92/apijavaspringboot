package com.nutritionapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritionapp.model.Paciente;

//@Repository
public interface IPacienteRepo extends JpaRepository<Paciente, Integer>{

}
