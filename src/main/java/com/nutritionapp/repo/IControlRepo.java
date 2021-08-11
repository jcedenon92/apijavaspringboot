package com.nutritionapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nutritionapp.model.Control;

//@Repository
public interface IControlRepo extends JpaRepository<Control, Integer>{

	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();
	
}
